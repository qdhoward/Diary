package NewAutumn.topic.DP;

public class GameTheory {
    public int greedyStrategy(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= j) {
                    if (i == j) {
                        dp[i][j] = nums[i];
                    }
                    continue;
                } else if (i == j - 1){
                    dp[i][j] = Math.max(nums[i], nums[j]);
                    continue;
                }
                //TODO case1 A take a[i]
                if (nums[i + 1] > nums[j]) {
                    dp[i][j] = dp[i + 2][j] + nums[i];
                } else {
                    dp[i][j] = dp[i + 1][j - 1] + nums[i];
                }
                //TODO case1 A take a[j]
                if (nums[i] > nums[j - 1]) {
                    dp[i][j] = Math.max(dp[i + 1][j - 1] + nums[j], dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 2] + nums[j], dp[i][j]);
                }
            }
        }
        return dp[0][nums.length - 1];
    }

    public int optimizeStrategy(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= j) {
                    if (i == j) {
                        dp[i][j] = nums[i];
                    }
                    continue;
                } else if (i == j - 1){
                    dp[i][j] = Math.max(nums[i], nums[j]);
                    continue;
                }
                //TODO case1 A take a[i]
                dp[i][j] = Math.min(dp[i + 2][j], dp[i + 1][j - 1]) + nums[i];
                //TODO case1 A take a[j]
                int case2 = Math.min(dp[i + 1][j - 1], dp[i][j - 2]) + nums[j];
                dp[i][j] = Math.max(case2, dp[i][j]);
            }
        }
        return dp[0][nums.length - 1];
    }
}
