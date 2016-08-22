package codility;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * Created by nohorbee on 21/08/16.
 */
public class RotateArray {
    int[] solution(int[] A, int K) {
        if (A.length<2) return A;
        int[] B = new int[A.length];
        for (int i=0;i<A.length;i++) {
            B[newIndex(i,K,A.length)] = A[i];
        }

        return B;
    }

    int newIndex(int i, int shift, int max) {
        if (shift==0) return i;
        return (i+shift<max ? i+shift : (i+shift)%max);
    }



    public static void main(String...args) {
        int[] a = {3,8,9,7,6};
        System.out.println("Gap: " + Arrays.toString(new RotateArray().solution(a,3)));
    }
}
