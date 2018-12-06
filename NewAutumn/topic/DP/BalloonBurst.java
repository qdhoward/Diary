package NewAutumn.topic.DP;

public class BalloonBurst {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        int[] numsResize = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            numsResize[i + 1] = nums[i];
        }
        numsResize[0] = 1;
        numsResize[nums.length + 1] = 1;
        for (int i = numsResize.length + 1; i >= 0; i--) {
            for (int j = 0; j < nums.length + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], numsResize[i] * numsResize[j] * numsResize[k] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][nums.length + 1];
    }
}
