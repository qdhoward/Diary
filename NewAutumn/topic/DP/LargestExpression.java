package NewAutumn.topic.DP;

public class LargestExpression {
    public double getLargestResult(double[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        double[][] dp = new double[nums.length][nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                    continue;
                }
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][k] + dp[k + 1][j], dp[i][j]);
                    dp[i][j] = Math.max(dp[i][k] * dp[k + 1][j], dp[i][j]);
                }
            }
        }
        return dp[0][nums.length - 1];
    }

    public double getLargestResultWithNegative(double[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        double[][] dp = new double[nums.length][nums.length];
        double[][] dpSmallest = new double[nums.length][nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                    dpSmallest[i][j] = nums[i];
                    continue;
                }
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][k] * dp[k + 1][j], dp[i][j]);
                    dp[i][j] = Math.max(dpSmallest[i][k] * dpSmallest[k + 1][j], dp[i][j]);

                    dpSmallest[i][j] = Math.min(dpSmallest[i][k] + dpSmallest[k + 1][j], dpSmallest[i][j]);
                    dpSmallest[i][j] = Math.min(dpSmallest[i][k] * dpSmallest[k + 1][j], dpSmallest[i][j]);
                    dpSmallest[i][j] = Math.min(dp[i][k] * dpSmallest[k + 1][j], dpSmallest[i][j]);
                    dpSmallest[i][j] = Math.min(dpSmallest[i][k] * dp[k + 1][j], dpSmallest[i][j]);
                }
            }
        }
        return dp[0][nums.length - 1];
    }
}
