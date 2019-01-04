package LeetCode.Topic.Array;

public class SortColors75 {
    public void sortColors(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(nums, mid++, left++);
            } else if (nums[mid] == 2) {
                //TODO mid不能移动，万一换过来的是0呢
                swap(nums, mid, right--);
            } else {
                mid++;
            }
        }
    }
    private void swap(int[] A, int left, int right) {
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
    }
}
