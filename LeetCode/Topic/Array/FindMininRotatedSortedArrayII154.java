package LeetCode.Topic.Array;

public class FindMininRotatedSortedArrayII154 {
    public int findMin(int[] nums) {
        //TODO 参考153
        //TODO left和right之间一定包含拐点，nums[mid] == nums[right]说明mid和right都在右半区域
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]){
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}
