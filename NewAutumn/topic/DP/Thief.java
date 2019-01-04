package NewAutumn.topic.DP;

public class Thief {
    public int maxValueOfMoney(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0] > 0 ? nums[0] : 0;
        dp[1] = nums[1] > 0 ? nums[1] : 0;
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
//    TODO 如果是circular array, 分两种情况
//    1. [0]被偷，那么从[2, n - 2]里找第一问的最大值就好
//    1. [0]没被偷，那么从[1, n - 1]里找第一问的最大值就好

    private int maxValueOfBinaryTree() {
        return 0;
    }
}
