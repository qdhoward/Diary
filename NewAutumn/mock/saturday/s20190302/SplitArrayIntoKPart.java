package NewAutumn.mock.saturday.s20190302;

import java.net.Inet4Address;
import java.util.Arrays;

public class SplitArrayIntoKPart {
    public int getMinPart(int[] array, int k) {
        Arrays.sort(array);
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        int left = 0;
        int right = array.length - 1;
        int target = sum / k;
        int res = Integer.MAX_VALUE;
        int cur = 0;
        while (left <= right) {
            //Greedy 可是拆分糖果顺序
            if (cur < target && cur + array[right] <= target) {
                cur += array[right];
                right--;
            } else if (cur < target) {
                cur += array[left];
                left++;
            } else {
                res = Math.min(res, cur);
                cur = 0;
            }
        }
        return res;
    }

    /*不可以拆分糖果顺序，就是加K个隔板
    dp[i][j] if we divide i element into j group, the max result we can get,

    dp[i][j] = max(min(dp[i - k][j - 1], sum of (array[j - k] to array[i])))
    prefix sum to optimize,

    base case dp[i][i] = min(array[k]), k from 0-i
	for i < j dp[i][j] = 0

    get the result : dp[array.length][k]
     */

    public int getMinPart2(int[] array, int k) {
        if (array == null || array.length < k) {
            return 0;
        }
        //TODO using off by 1 trick
        int[][] dp = new int[array.length + 1][k + 1];
        int[] prefixSum = new int[array.length];
        int min = array[0];
        int sum = 0;
        for (int i = 1; i < dp.length; i++) {
            min = Math.min(min, array[i - 1]);
            if (i <= k) {
                dp[i][i] = min;
            }
            sum += array[i - 1];
            prefixSum[i - 1] = sum;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == j) {
                    break;
                }
                if (j == 1) {
                    dp[i][j] = prefixSum[i - 1];
                    continue;
                }
                int currentMax = Integer.MIN_VALUE;
                //下面这么做不对，因为m不能保证m < i
//                for (int m = 1; m <= j - 1; m++) {
//                    currentMax = Math.max(currentMax, Math.min(dp[m][j - 1], prefixSum[i - 1] - prefixSum[m - 1]));
//                }
                for (int m = 1; i - m >= j; m++) {
                    currentMax = Math.max(currentMax, Math.min(dp[i - m][j - 1], prefixSum[i - 1] - prefixSum[i - m - 1]));
                }
                dp[i][j] = currentMax;
            }
        }
        System.out.println(
               Arrays.deepToString(dp)
        );
        return dp[dp.length - 1][k];
    }

    public static void main(String[] args) {
        System.out.println(
                new SplitArrayIntoKPart().getMinPart2(new int[] {3,2,4,5,2,1}, 2)
        );
    }
}
