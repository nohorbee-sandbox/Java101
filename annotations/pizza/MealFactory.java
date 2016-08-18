package annotations.pizza;


public class MealFactory {

  public Meal create(String id) {
    if (id == null) {
      throw new IllegalArgumentException("id is null!");
    }
    if ("Margarita".equals(id)) {
      return new annotations.pizza.MargaritaPizza();
    }

    throw new IllegalArgumentException("Unknown id = " + id);
  }
}
