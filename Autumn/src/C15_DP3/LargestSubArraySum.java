package C15_DP3;

import java.util.Arrays;

/**
 * Created by HaoYu on 2017/10/30.
 */
public class LargestSubArraySum {
    public int largestSum(int[] array) {
        int cur = 0;
        int globalMax = array[0];
        //TODO 初始值！
        for(int i = 0; i < array.length; i++) {
            cur = Math.max(cur + array[i], array[i]);
            globalMax = Math.max(globalMax, cur);
            //TODO 如果当前i加上之前传下来的还不如当前i，那么就舍弃，从当前i重新开始
            //M[i] 代表最大和of the subarray including the ith element, 为什么呢，因为要求是subarray, 必须是连续的！
        }
        return globalMax;
    }
    public int[] largestSumWithIndex(int[] array) {
        int cur  = array[0];
        int globalMax = array[0];
        int start = 0;
        int end = 0;
        int[] sol = new int[2];
        for (int i = 1; i < array.length; i++) {
            if (cur <= 0) {
                cur = array[i];
                start = i;
                end = i;//可以不写
            } else {
                cur = cur + array[i];
                end++;
            }
            if (cur > globalMax) {
                globalMax = cur;
                sol[0] = start;
                sol[1] = end;
            }
        }
        return sol;
    }
    public static void main(String[] args){
        System.out.print(Arrays.toString(new LargestSubArraySum().largestSumWithIndex(new int[] {2, 1, -6, -2, 1})));
    }
}
