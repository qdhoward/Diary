package LeetCode.BuyAndSellStock;

public class BuyandSellStock121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int res = 0;
        int dp = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (dp > prices[i]) {
                dp = prices[i];
            }
            res = Math.max(prices[i] - dp, res);
        }
        return res;
    }
}
