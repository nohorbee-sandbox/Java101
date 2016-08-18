package lambdas;

/**
 * Created by nherz on 8/15/16.
 */


interface BinaryCalculator {
    double calculate(double v1, double v2);
}

interface UnaryCalculator {
    double calculate(double v1);
}

public class Calculators {

    public static void main(String...args) {
        System.out.printf("18 + 36.5 = %f%n", calculate((v1,v2)->v1+v2, 18, 36.5));
        System.out.printf("89 / 2.9 = %f%n", calculate((v1,v2)->v1/v2, 89, 2.9));
        System.out.printf("-89 = %f%n", calculate(v1->-v1,89));
        System.out.printf("18 * 18 = %f%n", calculate(v1->v1*v1,18));
    }

    static double calculate(BinaryCalculator calculator, double v1, double v2) {
        return calculator.calculate(v1, v2);
    }

    static double calculate(UnaryCalculator calculator, double v1) {
        return calculator.calculate(v1);
    }

}
