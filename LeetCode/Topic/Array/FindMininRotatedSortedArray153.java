package LeetCode.Topic.Array;

public class FindMininRotatedSortedArray153 {
    public int findMin(int[] nums) {
        //TODO left和right之间一定包含拐点，nums[mid] <= nums[right]说明mid和right都在右半区域
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public int findMin2(int[] nums) {

        if (nums[0] <= nums[nums.length - 1]) {
            //TODO =是cover只有一个元素的情况
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
