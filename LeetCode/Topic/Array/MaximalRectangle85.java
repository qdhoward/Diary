package LeetCode.Topic.Array;

import java.util.Arrays;

public class MaximalRectangle85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = matrix[0][0] == '1' ? 1 : 0;
                } else if (i == 0) {
                    dp[0][j] = matrix[i][j] == '1' ? dp[0][j - 1] + 1 : 0;
                } else if (j == 0) {
                    dp[i][0] = matrix[i][j] == '1' ? dp[i - 1][0] + 1 : 0;
                } else {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximalRectangle85().maximalRectangle(
                new char[][] {
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                }
        ));
    }
}
