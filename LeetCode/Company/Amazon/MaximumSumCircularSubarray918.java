package LeetCode.Company.Amazon;

public class MaximumSumCircularSubarray918 {
    public int maxSubarraySumCircular(int[] A) {
        int[] array = A;
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int preSum = 0;
        int allSum = 0;
        for (int i = 0; i < array.length; i++) {
            allSum += array[i];
            if (preSum < 0) {
                max = Math.max(max, array[i]);
                preSum = array[i];
            } else {
                max = Math.max(max, array[i] + preSum);
                preSum += array[i];
            }
        }
        int min = Integer.MAX_VALUE;
        preSum = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (preSum < 0) {
                min = Math.min(min, preSum + array[i]);
                preSum += array[i];
            } else {
                min = Math.min(min, array[i]);
                preSum = array[i];
            }
        }
        return Math.max(max, allSum - min);
    }
}
