package LeetCode;

public class JumpGameII45 {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int[] dp = new int[nums.length]; //dp[i]: minimum step to reach end
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                dp[i] = Integer.MAX_VALUE;
            } else if (nums[i] >= nums.length - i - 1) {
                dp[i] = 1;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = i + nums[i]; j > i; j--) {
                    if (dp[i] > dp[j]){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        return dp[0];
    }
}
