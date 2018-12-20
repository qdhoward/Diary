package LeetCode.Facebook;

public class DecodeWays91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if (s.charAt(0) == '0') {
            return 0;
        } else {
            dp[0] = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i] += i >= 2 ? dp[i - 2] : 1;
                } else {
                    return 0;
                }
            } else {
                dp[i] += dp[i - 1];
                int num = getNumber(s.charAt(i - 1)) * 10 + getNumber(s.charAt(i));
                if (num <= 26 && num >= 10) {
                    dp[i] += i >= 2 ? dp[i - 2] : 1;
                }
            }
        }
        return dp[s.length() - 1];
    }

    private int getNumber(char c) {
        return c - '0';
    }
}
