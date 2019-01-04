package NewAutumn.topic.DP;

public class SplitIntoSquare {
    public int getMinStep(int target) {
        int[] dp = new int[target + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
            for (int j = 0; j * j <= i; j++) {
                if (j * j == i) {
                    dp[i] = 1;
                } else {
                    dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new SplitIntoSquare().getMinStep(14));
    }
}
