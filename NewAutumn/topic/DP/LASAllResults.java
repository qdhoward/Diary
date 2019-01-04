package NewAutumn.topic.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LASAllResults {
    //Longest Ascending Subsequence
    public List<Integer> solution(int[] array) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }
        int[] backindex = new int[array.length];
        int[] dp = new int[array.length];
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            dp[i] = 1;
            backindex[i] = -1;
            for (int j = 0; j <= i; j++) {
                if (array[i] > array[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    backindex[i] = j;
                    if (dp[i] > max) {
                        max = dp[i];
                        maxIndex = i;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(backindex));
        List<Integer> res = new ArrayList<>();
        res.add(array[maxIndex]);
        int nextIndex = maxIndex;
        while (backindex[nextIndex] != -1) {
            nextIndex = backindex[nextIndex];
            res.add(array[nextIndex]);
        }
        return res;
    }
}
