package LeetCode.BuyAndSellStock;

public class BuyandSellStockIV188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][k + 1];
        for (int j = 1; j <= k; j++) {
            int max = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                max = Math.max(max, dp[i][j - 1] - prices[i]);
                dp[i][j] = Math.max(prices[i] + max, dp[i - 1][j]);
            }
        }
        return dp[prices.length - 1][k];
    }
}
