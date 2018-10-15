package C2_BinarySearch;

/**
 * Created by HaoYu on 2017/9/29.
 */

public class Fibonacci {
    public long fibonacci(int K) {
        // Write your solution here
        if(K <= 0){
            return 0;
        }
        long a = 0;
        long b = 1;
        while(K > 1){
            long tmp = a + b;
            a = b;
            b = tmp;
            K--;
        }
        return b;
    }
}
