package C2_BinarySearch;

/**
 * Created by HaoYu on 2017/9/29.
 */
public class aPowerb {
    public long power(int a, int b) {
        // Write your solution here
        if(a == 1 || b == 0){
            return 1;
        }
        if(a == 0){
            return 0;
        }
        long half = power(a, b/2);
        return b % 2 == 0 ? half * half : half * half * a;
    }
    public long power2(int a, int b) {
        // Write your solution here
        if(a == 1 || b == 0){
            return 1;
        }
        if(a == 0) {
            return 0;
        }
        long res = 1;
        for(int i = 1; i <= b; i++){
            res = res * a;
        }
        return res;
    }
}
