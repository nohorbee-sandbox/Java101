

/**
 * Created by nherz on 8/14/16.
 */
public class Interfaces {
    public static void main(String args[]) {
        Shape shape = new Circle();
        shape.draw();
        shape = new Rectangle();
        shape.draw();
    }

}

interface Shape {
    void draw();
}



class Rectangle implements Shape {
    public void draw() {
        System.out.println("I'm a rectangle");
    }
}


class Circle implements Shape {
    public void draw() {
        System.out.println("I'm a circle");
    }
}