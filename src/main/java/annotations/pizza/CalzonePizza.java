package annotations.pizza;

/**
 * Created by nherz on 8/16/16.
 */
@Factory(type = Meal.class, id = "Calzone")
public class CalzonePizza implements Meal {

    @Override
    public float getPrice() {
        return 8.5f;
    }
}
