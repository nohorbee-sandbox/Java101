package codility;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nohorbee on 22/08/16.
 */
public class OddOccurrencies {

    int solutionON(int[] A) {
        int result = -1;
        for (int a : A) {
            if (result==-1) {
                result = a;
            } else {
                result ^= a;
            }
        }

        return result;
    }

    int solution(int[] A) {
        Map<Integer, Integer> indexed = new HashMap<>();
        for (int a : A) {
            if (null!=indexed.get(a)) {
                indexed.remove(a);
            } else {
                indexed.put(a,0);
            }
        }

        return (int)indexed.keySet().toArray()[0];
    }

    public static void main(String...args) {
        int[] a={9,5,5,10,22,10,9};
        System.out.println(new OddOccurrencies().solutionON(a));
        System.out.println(new OddOccurrencies().solution(a));
    }

}
