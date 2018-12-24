package LeetCode.Topic.Array;

public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        int fast = 0;
        //TODO slow excluding itself
        while (fast < nums.length) {
            if (nums[fast] == val) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }
}
