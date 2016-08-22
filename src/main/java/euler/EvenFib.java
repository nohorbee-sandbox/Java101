package euler;

/**
 * Created by nohorbee on 22/08/16.
 */
public class EvenFib {
    public static void main(String...args) {
        int current=1, previous=1, sum=0, temp;
        while(current<=4000000) {
            System.out.print(current + ",");
            sum += (current % 2 == 0 ? current : 0);
            temp = current;
            current += previous;
            previous = temp;
        }
        System.out.println("\nSUM:"+sum);
    }
}
