package NewAutumn.mock.saturday.s20190309;

import java.util.Arrays;

public class AttendAllMeeting {
    public int maxNumOfMeeting(int[][] array) {
        int[] dp = new int[array.length];
        Arrays.sort(array);
        int res = 1;
        for (int i = 0; i < array.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j][1] < array[i][0]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
