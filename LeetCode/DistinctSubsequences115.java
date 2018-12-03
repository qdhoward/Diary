package LeetCode;

public class DistinctSubsequences115 {
    public int numDistinct(String s, String t) {
        //TODO 空间复杂度是n 优化2
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            int pre = 1;
            for (int j = 1; j <= t.length(); j++) {
                int tmp = dp[j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = pre + dp[j];
                } else {
                    dp[j] = tmp;//TODO 不同的话，直接继承上一层的结果
                }
                pre = tmp;
            }
        }
        return dp[t.length()];
    }

    public int numDistinct2(String s, String t) {
        //TODO 空间复杂度是2n 优化1
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }
        int[][] dp = new int[2][t.length() + 1];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[1][j] = dp[0][j - 1] + dp[0][j];
                    dp[0][j - 1] = dp[1][j - 1];
                } else {
                    dp[1][j] = dp[0][j];
                    dp[0][j - 1] = dp[1][j - 1];
                }
            }
            dp[0][t.length()] = dp[1][t.length()];
        }
        return dp[s.length()][t.length()];
    }
    public int numDistinct3(String s, String t) {
        //TODO 空间复杂度是n^2 无优化
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
