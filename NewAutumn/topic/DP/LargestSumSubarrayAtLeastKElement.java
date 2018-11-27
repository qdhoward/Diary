package NewAutumn.topic.DP;

public class LargestSumSubarrayAtLeastKElement {
    public int maxSum(int[] array, int k) {
        int[] prefixSum = new int[array.length];
        int curSum = 0;
        for (int i = 0; i < array.length; i++) {
            curSum += array[i];
            prefixSum[i] = curSum;
        }
        int min = Integer.MAX_VALUE;
        int[] dp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            min = Math.min(min, array[i]);
            dp[i] = min;
            prefixSum[i] = curSum;
        }

        int res = Integer.MIN_VALUE;
        for (int i = k - 1; i < array.length; i++) {
            int minBeforej = i - k < 0 ? 0 : dp[i - k];//TODO prefix要注意头元素！
            res = Math.max(res, prefixSum[i] - minBeforej);
        }
        return res;
    }
}
