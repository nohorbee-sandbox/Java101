package functionalinterface;

import java.util.function.Function;

/**
 * Created by nherz on 8/17/16.
 */
public class FunctionalInterface {

    private String name;

    public FunctionalInterface(String name) {
        this.name = name;
        System.out.println("Called with name");
    }

    public FunctionalInterface() {
        this.name = "";
    }

    public static void main(String...args) {
        Function<String, FunctionalInterface> function = FunctionalInterface::new;
        function.apply("aaa");
    }
}
