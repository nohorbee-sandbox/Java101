package annotations.pizza;

/**
 * Created by nherz on 8/16/16.
 */
public class DeprecatedMealFactory {

    public Meal create (String id) {
        switch (id) {
            case "Margarita": {
                return new MargaritaPizza();
            }
            case "Calzone": {
                return new CalzonePizza();
            }
            case "Tiramisu": {
                return new Tiramisu();
            }
            default: {
                throw new IllegalArgumentException("Unknown meal " + id);
            }
        }
    }

}
