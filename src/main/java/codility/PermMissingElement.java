package codility;

/**
 * Created by nohorbee on 22/08/16.
 */
public class PermMissingElement {

    public int solution (int[] A) {
        int arrXor = 0;
        int totXor = 0;

        for(int i=0;i<A.length;i++) {
            arrXor ^= A[i];
            totXor ^= i+1;
        }
        totXor ^= A.length+1;
        return arrXor^totXor;

    }

    public static void main(String...args) {
        int[] a = {2,3,1,5};
        System.out.println (new PermMissingElement().solution(a));
    }

}
