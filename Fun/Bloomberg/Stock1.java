package Fun.Bloomberg;

public class Stock1 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minPrices = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrices = Math.min(prices[i], minPrices);
            res = Math.max(res, prices[i] - minPrices);
        }
        return res;
    }
}
