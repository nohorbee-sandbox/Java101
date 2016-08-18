package staticimport;

import static annotations.Switchable.*;

/**
 * Created by nherz on 8/15/16.
 */
public class Light {
    private boolean state = OFF;

    public void printState() {
        System.out.printf("state = %s%n", (state == OFF) ? "OFF" : "ON");
    }

    public void toggle() {
        state = (state == OFF) ? ON : OFF;
    }
}
