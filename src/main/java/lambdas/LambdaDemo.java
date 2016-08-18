package lambdas;

/**
 * Created by nherz on 8/15/16.
 */
public class LambdaDemo {
    public static void main(String...args) {

        new Thread(()-> System.out.println("Hello Lambda")).start();

    }



}

class testRun implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello World");
    }
}

