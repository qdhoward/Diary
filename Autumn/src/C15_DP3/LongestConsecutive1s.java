package C15_DP3;

/**
 * Created by HaoYu on 2017/11/5.
 */
public class LongestConsecutive1s {
    public int longest(int[] array) {
        // Write your solution here.
        int cur = 0;
        int globalMax = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                cur++;
            } else {
                cur = 0;
            }
            globalMax = Math.max(cur, globalMax);
        }
        return globalMax;
    }
}
