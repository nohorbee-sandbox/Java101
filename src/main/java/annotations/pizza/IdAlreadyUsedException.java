package annotations.pizza;

/**
 * Created by nherz on 8/17/16.
 */
public class IdAlreadyUsedException extends Exception {

    private FactoryAnnotatedClass existing;

    public IdAlreadyUsedException(FactoryAnnotatedClass existing) {
        this.existing = existing;
    }

    public FactoryAnnotatedClass getExisting() {
        return existing;
    }
}
