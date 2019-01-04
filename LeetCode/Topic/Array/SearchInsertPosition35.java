package LeetCode.Topic.Array;

public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //TODO 虽然是找比target大的最小的数，但数组里面可能不存在这个数
        if (nums[right] >= target) {
            return right;
        } else {
            return right + 1;
        }
    }
}
