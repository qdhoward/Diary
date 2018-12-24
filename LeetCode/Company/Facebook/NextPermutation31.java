package LeetCode.Company.Facebook;

public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        boolean flag = true;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                flag = false;
                int index = findSmallestLarger(nums, i, nums[i - 1]);
                int tmp = nums[index];
                nums[index] = nums[i - 1];
                nums[i - 1] = tmp;
                swap(nums, i);
                return;
            }
        }
        if (flag) {
            swap(nums, 0);
        }
    }

    private void swap(int[] nums, int begin) {
        int left = begin;
        int right = nums.length - 1;
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }

    private int findSmallestLarger(int[] nums, int begin, int target) {
        int left = begin;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (nums[right] > target) {
            return right;
        } else {
            return left;
        }
    }
}
