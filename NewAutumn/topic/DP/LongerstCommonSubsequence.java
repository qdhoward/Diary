package NewAutumn.topic.DP;

import java.util.Arrays;

public class LongerstCommonSubsequence {
    public String longest(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    if (dp[i - 1][j] > dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = s.length();
        int j = t.length();
        while (i >= 1 && j >= 1) {
            if (s.charAt(i - 1) == t.charAt(j - 1)) {
                sb.append(s.charAt(i - 1));
                i -= 1;
                j -= 1;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i -= 1;
                } else {
                    j -= 1;
                }
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        LongerstCommonSubsequence test = new LongerstCommonSubsequence();
        System.out.println(test.longest("abcde", "cbabdfe"));
    }
}
