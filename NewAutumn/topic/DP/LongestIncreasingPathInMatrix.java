package NewAutumn.topic.DP;


public class LongestIncreasingPathInMatrix {
    private static int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longest(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                dp[i][j] = 1;
                int max = 0;
                for (int[] direction : directions) {
                    int nextI = i + direction[0];
                    int nextJ = j + direction[1];
                    if (outOfBoundary(nextI, nextJ, matrix.length, matrix[0].length)) {
                        continue;
                    }
                    if (matrix[nextI][nextJ] > matrix[i][j]) {
                        max = Math.max(max, dp[nextI][nextJ]);
                    }
                }
                dp[i][j] = max + 1;
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }

    private boolean outOfBoundary(int i, int j, int row, int col) {
        return i <= 0 || i >= row || j <= 0 || j >= col;
    }
}
