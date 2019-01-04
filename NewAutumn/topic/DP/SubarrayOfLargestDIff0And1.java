package NewAutumn.topic.DP;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;

public class SubarrayOfLargestDIff0And1 {
    public int[] findArray(int[] array) {
        if (array.length == 0) {
            return new int[0];
        }
        int[] refine = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            refine[i] = array[i] == 1 ? 1 : -1;
        }
        int[] max = findLargestSumSubarray(refine);
        int[] min = findSmallestSumSubarray(refine);
        if (max[0] > Math.abs(min[0])) {
            return Arrays.copyOfRange(array, max[2], max[1]);
        } else {
            return Arrays.copyOfRange(array, min[2], min[1]);
        }
    }

    private int[] findLargestSumSubarray(int[] array) {
        int[] dp = new int[array.length];
        int[] index = new int[array.length];
        dp[0] = array[0];
        index[0] = -1;
        int max = 0;
        int res = 0;
        int start = 0;
        for (int i = 1; i < array.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = array[i] + dp[i - 1];
                index[i] = start;
            } else {
                dp[i] = array[i];
                index[i] = -1;
                start = i;
            }
            if (dp[i] > max) {
                max = dp[i];
                res = i;
            }
        }
        return new int[] {max, res, index[res]};
    }

    private int[] findSmallestSumSubarray(int[] array) {
        int[] dp = new int[array.length];
        int[] index = new int[array.length];
        dp[0] = array[0];
        index[0] = -1;
        int min = 0;
        int res = 0;
        int start = 0;
        for (int i = 1; i < array.length; i++) {
            if (dp[i - 1] < 0) {
                dp[i] = array[i] + dp[i - 1];
                index[i] = start;
            } else {
                dp[i] = array[i];
                index[i] = -1;
                start = i;
            }
            if (dp[i] < min) {
                min = dp[i];
                res = i;
            }
        }
        return new int[] {min, res, index[res]};
    }
}
