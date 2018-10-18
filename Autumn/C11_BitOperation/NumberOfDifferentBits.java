package C11_BitOperation;

/**
 * Created by HaoYu on 2017/10/30.
 */
public class NumberOfDifferentBits {
    public int diffBits(int a, int b) {
        //TODO 此处假设ab都是正数
        // Write your solution here.
        int diff = a ^ b;
        int count = 0;
        while (diff != 0) {
            count += diff & 1;
            diff = diff >>> 1;
        }
        return count;
    }
}
