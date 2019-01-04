package NewAutumn.topic.DP;

import java.util.Arrays;

public class LongestAscendingSubsequence {
    //Time O(nlogn)
    public int longest(int[] array) {
        // Write your solution here.
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = 0;
        int[] refine = new int[array.length];
        refine[0] = array[0];
        for (int i = 0; i < array.length; i++) {
            int index = findLargestSmaller(refine, 0, result, array[i]);
            if (index == result) {
                refine[++result] = array[i];
            } else {
                refine[index + 1] = array[i];
            }
        }
        System.out.println(Arrays.toString(refine));
        return result + 1;
    }

    private int findLargestSmaller(int[] array, int left, int right, int target) {
        //TODO in this exerciese, it's including target.
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    //TODO Pure recursion
    public int findLongeest(int[] nums) {
        return helper(nums, nums.length - 1, new int[nums.length]);
    }

    private int helper(int[] nums, int index, int[] memo) {
        if (memo[index] != 0 ) {
            return memo[index];
        }
        int longest = 1;
        for (int i = index - 1; i >= 0; i--) {
            if (nums[index] > nums[i]) {
                longest = Math.max(longest, helper(nums, i, memo) + 1);
            }
        }
        memo[index] = longest;
        return longest;
    }
}
