package LeetCode.Topic.Array;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        //TODO slow including itself
        while (fast < nums.length) {
            if (nums[fast] == nums[slow]) {
                fast++;
            } else {
                nums[++slow] = nums[fast++];
            }
        }
        return slow + 1;
    }
}
