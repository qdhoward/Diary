package NewAutumn.topic.DP;

public class LargestSquareOf1 {
    public int lrgestSqure(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == 1 ? 1 : 0;
                    continue;
                }
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.max(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
