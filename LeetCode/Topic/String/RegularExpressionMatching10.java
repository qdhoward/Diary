package LeetCode.Topic.String;

public class RegularExpressionMatching10 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //TODO off by 1 trick 注意要要到length + 1 !!!
        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < p.length() + 1; j++) {
                //Base case
                if (i == 0 && j == 0) {
                    dp[0][0] = true;
                    continue;
                } else if (j == 0) {
                    dp[i][0] = false;
                    continue;
                } else if (i == 0 && j == 1) {
                    dp[0][1] = false;
                    continue;
                } else if (i == 0){
                    dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
                    continue;
                }
                //Induction rule
                if (p.charAt(j - 1) != '*' && p.charAt(j - 1) != '.') {
                    dp[i][j] = s.charAt(i - 1) == p.charAt(j - 1) && dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) != '.' && p.charAt(j - 2) != s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j - 2];
                    } else if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching10().isMatch("aa",
                "a*"));
    }
}
