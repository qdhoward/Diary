package NewAutumn.refresh.CrossTraining7;

import java.util.Set;

public class LongestCommonSubstring {
    public int solution(String a, String b) {
        int[][] dp = new int[a.length()][b.length()];
        for (int i = 0; i < a.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < b.length(); i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {

            }
        }
        return 0;
    }
}
