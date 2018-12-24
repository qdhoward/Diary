package LeetCode.Company.Amazon;

import java.util.Arrays;

public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (coins.length == 0) {
            return -1;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = -1;
                    continue;
                }
                if (dp[i - 1][j] == -1 && (j - coins[i - 1] < 0 || dp[i][j - coins[i - 1]] == -1)) {
                    dp[i][j] = -1;
                } else if (dp[i - 1][j] != -1 && j - coins[i - 1] >= 0 && dp[i][j - coins[i - 1]] != -1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                } else if (dp[i - 1][j] != -1) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j - coins[i - 1] >= 0 || dp[i][j - coins[i - 1]] != -1){
                    dp[i][j] = dp[i][j - coins[i - 1]] + 1;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[coins.length][amount];
    }
    public static void main(String[] args) {
        System.out.println(new CoinChange322().coinChange(new int[] {1, 2, 5}, 11));
    }
}
