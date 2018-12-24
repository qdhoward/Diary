package LeetCode.Company.Amazon;

public class MaximumSubarray53 {
    public int maxSubArray(int[] nums) {
        int[] array = nums;
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int preSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (preSum < 0) {
                max = Math.max(max, array[i]);
                preSum = array[i];
            } else {
                max = Math.max(max, array[i] + preSum);
                preSum += array[i];
            }
        }
        return max;
    }
}
