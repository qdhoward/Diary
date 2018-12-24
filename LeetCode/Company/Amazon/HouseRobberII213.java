package LeetCode.Company.Amazon;

public class HouseRobberII213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max;
        //TODO case1 0 is stolen
        max = nums[0] + Math.max(helper(nums, 2, nums.length - 2), 0);
        //TODO case2 0 is not stolen
        max = Math.max(max, helper(nums, 1, nums.length - 1));
        return max;
    }

    public int helper(int[] nums, int left, int right) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for (int i = left; i <= right; i++) {
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
}
