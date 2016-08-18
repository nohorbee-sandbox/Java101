package annotations.pizza;

/**
 * Created by nherz on 8/16/16.
 */
@Factory(type=Meal.class, id = "Tiramisu")
public class Tiramisu implements Meal {

    @Override
    public float getPrice() {
        return 4.5f;
    }
}
