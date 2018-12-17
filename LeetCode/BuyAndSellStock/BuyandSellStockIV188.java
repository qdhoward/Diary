package LeetCode.BuyAndSellStock;

public class BuyandSellStockIV188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }
        if (k >= prices.length / 2) return quickSolve(prices);
        int[][] dp = new int[prices.length][k + 1];
        for (int j = 1; j <= k; j++) {
            int max = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][j] = Math.max(prices[i] + max, dp[i - 1][j]);
                max = Math.max(max, dp[i][j - 1] - prices[i]);
            }
        }
        return dp[prices.length - 1][k];
    }
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
