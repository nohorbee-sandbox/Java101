package codility;

/**
 * Created by nohorbee on 21/08/16.
 */
public class BinaryGap {
    int solution(int N) {

        int len = 0;
        N = N | (N-1);
        while((N&N+1)!=0) {
            len++;
            N=N|N<<1;
        }
        return len;
    }

    public static void main(String...args) {
        System.out.println("Gap: " + new BinaryGap().solution(32));
    }
}
