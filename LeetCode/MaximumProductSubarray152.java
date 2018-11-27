package LeetCode;

public class MaximumProductSubarray152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] largest = new int[nums.length];
        int[] smallest = new int[nums.length];
        largest[0] = nums[0];
        smallest[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            largest[i] = Math.max(smallest[i - 1] * nums[i], Math.max(nums[i], largest[i - 1] * nums[i]));
            smallest[i] = Math.min(smallest[i - 1] * nums[i], Math.min(nums[i], largest[i - 1] * nums[i]));
            res = Math.max(res, largest[i]);
        }
        return res;
    }
}
