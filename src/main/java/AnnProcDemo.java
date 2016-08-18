import annotations.ToDo;

import java.lang.reflect.Method;

/**
 * Created by nherz on 8/15/16.
 */


public class AnnProcDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        if (args.length != 1) {
            System.out.println("usage: java AnnProcDemo classfile");
            return;
        }

        Method[] methods = Class.forName(args[0]).getMethods();
        for (Method method: methods) {
            if (method.isAnnotationPresent(ToDo.class)) {
                ToDo todo = method.getAnnotation(ToDo.class);
                String[] components = todo.value().split(",");
                System.out.printf("ID = %s%n", components[0]);
                System.out.printf("Finish date = %s%n", components[1]);
                System.out.printf("Coder = %s%n%n", components[2]);
            }
        }



    }



}
