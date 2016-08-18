package annotations.pizza;

/**
 * Created by nherz on 8/16/16.
 */
@Factory(type = Meal.class, id="Margarita")
public class MargaritaPizza implements Meal {

    @Override
    public float getPrice() {
        return 6.0f;
    }


}
