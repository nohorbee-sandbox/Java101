package annotations.pizza;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by nherz on 8/16/16.
 */
@AutoService(Processor.class)
public class FactoryProcessor extends AbstractProcessor{

    private Types typeUtils;
    private Elements elementUtils;
    private Filer filer;
    private Messager messager;
    private Map<String, FactoryGroupedClasses> factoryClasses = new LinkedHashMap<>();

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        typeUtils = processingEnv.getTypeUtils();
        elementUtils = processingEnv.getElementUtils();
        filer = processingEnv.getFiler();
        messager = processingEnv.getMessager();
    }
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotations = new LinkedHashSet<>();
        annotations.add(Factory.class.getCanonicalName());
        return annotations;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("IN PROCESS");
        for (Element annotatedElement : roundEnv.getElementsAnnotatedWith(Factory.class)) {
            if (annotatedElement.getKind() != ElementKind.CLASS) {
                error(annotatedElement, "Only classes can be annotated with @%s", Factory.class.getSimpleName());
                return true;
            }

            TypeElement typeElement = (TypeElement) annotatedElement;

            try {
                FactoryAnnotatedClass annotatedClass = new FactoryAnnotatedClass(typeElement);
                if (!isValidClass(annotatedClass)) return true;  //  The error is printed inside the isValidClass method

                FactoryGroupedClasses factoryClass = factoryClasses.get(annotatedClass.getQualifiedFactoryGroupName());
                if (factoryClass==null) {

                    String qualifiedGroupName = annotatedClass.getQualifiedFactoryGroupName();
                    factoryClass = new FactoryGroupedClasses(qualifiedGroupName);
                    factoryClasses.put(qualifiedGroupName, factoryClass);
                }
                factoryClass.add(annotatedClass);

            } catch(IllegalArgumentException e) {
                error(typeElement, e.getMessage());
                return true;
            } catch (IdAlreadyUsedException e) {
                error(annotatedElement, "Conflict: The class %s is annotated with @%s with" +
                        "id = '%s' but %s already uses the same id", typeElement.getQualifiedName().toString(),
                        Factory.class.getSimpleName(), e.getExisting().getTypeElement().getQualifiedName().toString());
                return true;
            }

            try {
                for (FactoryGroupedClasses factoryClass : factoryClasses.values()) {
                    factoryClass.generateCode(elementUtils, filer);
                }
                factoryClasses.clear();
            } catch (IOException e) {
                error(null, e.getMessage());
            }

        }
        return true;
    }

    private boolean isValidClass(FactoryAnnotatedClass item) {
        TypeElement classElement = item.getTypeElement();
        if(!classElement.getModifiers().contains(Modifier.PUBLIC)) {
            error(classElement, "The class %s is not public", classElement.getQualifiedName().toString());
            return false;
        }

        if(classElement.getModifiers().contains(Modifier.ABSTRACT)) {
            error(classElement, "The class %s is abstract. You can' annotate abstract classes with @%", classElement.getQualifiedName().toString(), Factory.class.getSimpleName());
            return false;
        }

        TypeElement superClassElement = elementUtils.getTypeElement(item.getQualifiedFactoryGroupName());
        if (superClassElement.getKind() == ElementKind.INTERFACE) {
            if(!classElement.getInterfaces().contains(superClassElement.asType())) {
                error(classElement, "The class %s annotated with @%s must implement the interface %s",
                        classElement.getQualifiedName().toString(), Factory.class.getSimpleName(),
                        item.getQualifiedFactoryGroupName());
                return false;
            }
        } else {
            TypeElement currentClass = classElement;
            while(true) {
                TypeMirror superClassType = currentClass.getSuperclass();

                if (superClassType.getKind() == TypeKind.NONE) {
                    // java.lang.Object reached
                    error(classElement, "The class %s annotated with @%s must inherit from %s", classElement.getQualifiedName().toString(),
                            Factory.class.getSimpleName(), item.getQualifiedFactoryGroupName());
                    return false;
                }

                if (superClassType.toString().equals(item.getQualifiedFactoryGroupName())) { break; }
                currentClass = (TypeElement) typeUtils.asElement(superClassType);

            }
        }

        for(Element enclosed : classElement.getEnclosedElements()) {
            if (enclosed.getKind() == ElementKind.CONSTRUCTOR) {
                ExecutableElement constructorElement = (ExecutableElement) enclosed;
                if(constructorElement.getParameters().size() == 0 && constructorElement.getModifiers().contains(Modifier.PUBLIC))
                    return true;
            }
        }

        error(classElement, "The class %s must provide a public empty default constructor", classElement.getQualifiedName().toString());
        return false;
    }


    private void error(Element e, String msg, Object...args) {
        messager.printMessage(
                Diagnostic.Kind.ERROR,
                String.format(msg, args),
                e
        );
    }


}
