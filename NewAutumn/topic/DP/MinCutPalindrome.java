package NewAutumn.topic.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinCutPalindrome {
    public int minCut(String s) {
        int dp[] = new int[s.length()];
        boolean check[][] = new boolean[s.length()][s.length()];
        Map<Integer, List<Integer>> backindex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            dp[i] = i;
            for (int j = 0; j <= i; j++) {
                if (j == i) {
                    check[i][j] = true;
                }
                if (s.charAt(j) == s.charAt(i) && (i - j <= 1 || check[j + 1][i - 1])) {
                    check[j][i] = true;
                    if (!backindex.containsKey(i)) {
                        backindex.put(i, new ArrayList<>());
                    }
                    if (j == 0) {
                        dp[i] = 0;
                        backindex.get(i).add(0);
                    } else {
                        if (dp[j - 1] + 1 < dp[i]) {
                            dp[i] = dp[j - 1] + 1;
                            backindex.get(i).clear();
                            backindex.get(i).add(j - 1);
                        } else if (dp[j - 1] + 1 == dp[i]) {
                            backindex.get(i).add(j - 1);
                        }
                    }
                }
            }
        }
        System.out.println(backindex);
        return dp[s.length() - 1];
    }
}
