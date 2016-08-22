package codility;

/**
 * Created by nohorbee on 22/08/16.
 */
public class TapeEquilibrum {

    int solution(int[] A) {

        int total = 0;
        for (int a : A) {
            total += a;
        }
        int minDiff = Integer.MAX_VALUE;
        int acum = 0;
        int currentDiff;
        for (int i=0;i<A.length-1;i++) {
            acum += A[i];
            currentDiff = Math.abs(2*(acum)-total);
            minDiff = Integer.min(minDiff, currentDiff);
        }

        return minDiff;
    }

    public static void main(String...args) {
        int[] a = {-1000,1000};
        System.out.println(new TapeEquilibrum().solution(a));
    }

}
