package LeetCode.Company.Amazon;

import java.util.Arrays;

public class FirstMissingPositive41 {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] > 0) {
                i++;
            } else if (nums[j] <= 0) {
                j--;
            } else {
                swap(nums, i++, j--);
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(i);
        for (int k = 0; k < i; k++) {
            int abs = Math.abs(nums[k]);
            if (abs <= i && nums[abs - 1] > 0) {
                nums[abs - 1] *= -1;
            }
        }
        System.out.println(Arrays.toString(nums));
        int result = i + 1;
        for (int k = 0; k < i; k++) {
            if (nums[k] > 0) {
                result = k + 1;
                return result;
            }
        }
        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
