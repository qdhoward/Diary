package C12_DP1;

/**
 * Created by HaoYu on 2017/10/21.
 */
public class Fibonacci {
    public long fibonacci(int K) {
        if (K <= 0) {
            return 0;
        }
        long a = 0;
        long b = 1;
        while (K > 1) {
            long tmp = a + b;
            a = b;
            b = tmp;
            K--;
        }
        return b;
    }
}
