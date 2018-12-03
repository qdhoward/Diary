package NewAutumn.topic.DP;

public class LongestCommonSubstring {
    public String longestCommon(String s, String t) {
        if(s.equals("")  || t.equals("")){
            return "";
        }
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        int end = 0;
        int max = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (int  j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > max) {
                    end = i - 1;
                    max = dp[i][j];
                }
            }
        }
        return s.substring(end - max + 1, end + 1);
    }
}
