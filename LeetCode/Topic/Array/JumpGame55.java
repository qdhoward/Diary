package LeetCode.Topic.Array;

public class JumpGame55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 0; j <= nums[i]; j++) {
                if (i + j >= nums.length || dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
