package codility;

/**
 * Created by nohorbee on 22/08/16.
 */
public class FrogJmp {

    public int solution (int X, int Y, int D) {
        return (int)Math.ceil((double) (Y-X)/D);
    }

    public static void main(String...args) {
        System.out.println (new FrogJmp().solution(2,1000000000,2));
    }

}
