package LeetCode;

public class EditDistance72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
            for (int j = 1; j <= word2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
                        dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
                    }
                }
            }
        }
    }
}
