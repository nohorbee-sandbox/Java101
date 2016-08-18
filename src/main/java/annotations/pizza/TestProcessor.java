package annotations.pizza;

/**
 * Created by nherz on 8/16/16.
 */
public class TestProcessor {
    public static void main(String[] args) {
        String arguments[] = {"-proc:only", "-processor", "annotations.pizza.FactoryProcessor", "src/main/java/annotations/pizza/MargaritaPizza.java"};
        try {
            System.out.println("Start processing");
            com.sun.tools.javac.Main.main(arguments);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
