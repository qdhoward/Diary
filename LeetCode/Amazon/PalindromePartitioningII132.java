package LeetCode.Amazon;


public class PalindromePartitioningII132 {
    public int minCut(String s) {
        int dp[] = new int[s.length()];
        boolean check[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = i;
            for (int j = 0; j <= i; j++) {
                if (j == i) {
                    check[i][j] = true;
                }
                if (s.charAt(j) == s.charAt(i) && (i - j <= 1 || check[j + 1][i - 1])) {
                    check[j][i] = true;
                    if (j == 0) {
                        dp[i] = 0;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        PalindromePartitioningII132 test = new PalindromePartitioningII132();
        System.out.println(test.minCut("aabaacddc"));
    }


    public int minCut2(String s) {
        int dp[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = i;
            if (isPalindrome(s, 0, i)) {
                dp[i] = 0;
                continue;
            }
            for (int j = 1; j <= i; j++) {
                if (isPalindrome(s, j, i)) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[s.length() - 1];
    }

    private boolean isPalindrome (String input, int left, int right) {
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
