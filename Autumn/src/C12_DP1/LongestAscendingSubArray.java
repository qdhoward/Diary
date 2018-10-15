package C12_DP1;

/**
 * Created by HaoYu on 2017/10/29.
 */
public class LongestAscendingSubArray {
    public int longest(int[] array) {
        // Write your solution here.
        if (array.length == 0) {
            return 0;
        }
        int globalMax = 1;
        int curMax = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                curMax++;
                globalMax = Math.max(globalMax, curMax);
            } else {
                curMax = 1;
            }
        }
        return globalMax;
    }
    public static void main(String[] args){
        System.out.print(new LongestAscendingSubArray().longest(new int[] {7,1}));
    }
}
