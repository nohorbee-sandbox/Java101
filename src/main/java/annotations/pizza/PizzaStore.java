package annotations.pizza;

/**
 * Created by nherz on 8/16/16.
 */
public class PizzaStore {

    public static void main(String...args) {

        PizzaStore store = new PizzaStore();
        if (args.length!=1) {
            System.out.println("Specify the name of the meal");
            return;
        }
        Meal meal = store.order(args[0]);
        System.out.println(meal.getPrice());

    }


    public Meal order(String mealName) {
        //return new MealFactory().create(mealName);
        return new MargaritaPizza();
    }

}
