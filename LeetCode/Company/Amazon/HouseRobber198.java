package LeetCode.Company.Amazon;

public class HouseRobber198 {
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            if (i >= 2) {
                //TODO case1 i is stolen
                dp[i] = Math.max(dp[i], dp[i - 2] + nums[i]);
            }
            if (i >= 1) {
                //TODO case2 i is not stolen
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            if (i >= 2) {
                dp[i] = Math.max(dp[i], dp[i - 2] + nums[i]);
            }
            if (i >= 3) {
                dp[i] = Math.max(dp[i], dp[i - 3] + nums[i]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
