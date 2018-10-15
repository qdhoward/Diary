package C28_Enhanced7;

import C12_DP1.LongestAscendingSubArray;

import java.util.Arrays;

/**
 * Created by HaoYu on 2018/2/26.
 */
public class LongestCommonSubsequence {
    public int longest(String s, String t) {
        // Write your solution here
        char[] arrays = s.toCharArray();
        char[] arrayt = t.toCharArray();
        int[][] dp = new int[s.length()][t.length()];
        int res = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrayt.length; j++) {
                if (arrays[i] == arrayt[j]) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        //TODO 注意如果相等的话，还是继承自i-1 j-1，不等的话继承自dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
                    }
                } else {
                    if (i ==0 && j == 0) {
                      dp[i][j] = 0;
                    } else if (i == 0 && j > 0){
                        dp[i][j] = dp[i][j - 1];
                    } else if (j == 0 && i > 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
                if (dp[i][j] > res) {
                    res = dp[i][j];
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(new LongestCommonSubsequence().longest("abbcdddeffg","bcbbcdf"));
//        System.out.println(Arrays.deepToString(new LongestCommonSubsequence().longest("abcde", "cbabdfe")));
    }
}
