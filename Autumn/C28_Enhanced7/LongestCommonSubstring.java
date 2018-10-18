package C28_Enhanced7;

/**
 * Created by HaoYu on 2018/2/26.
 */
public class LongestCommonSubstring {
    public String longestCommon(String s, String t) {
        // Write your solution here.
        int[][] dp = new int[s.length()][t.length()];
        char[] arrays = s.toCharArray();
        char[] arrayt = t.toCharArray();
        int largest = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (arrays[i] == arrayt[j]) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                if (dp[i][j] > largest) {
                    largest = dp[i][j];
                    start = i - largest + 1;//TODO i是结束的位置
                }
            }
        }
        return s.substring(start, start + largest);
    }
    public static void main(String[] args){
        System.out.println(new LongestCommonSubstring().longestCommon("abcde", "cdf"));
    }
}
