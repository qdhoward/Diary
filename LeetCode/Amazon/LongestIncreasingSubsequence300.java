package LeetCode.Amazon;

public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS_DP(int[] nums) {
        //Time O(n^2) Space O(n)
        int[] res = new int[nums.length];
        int  max = 0;
        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    res[i] = Math.max(res[j] + 1, res[i]);
                }
            }
            max = Math.max(max, res[i]);
        }
        return max;
    }

    public int lengthOfLIS(int[] nums) {
        //Time O(2^n) Space O(n)
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(recursion(nums, nums.length - 1), max);
        }
        return max;
    }

    public int recursion(int[] nums, int index) {
        int max = 1;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[index] > nums[i]) {
                int longest = recursion(nums, i);
                max = Math.max(max, longest + 1);
            }
        }
        return max;
    }
//    [1,3,6,7,9,4,10,5,6]
}
