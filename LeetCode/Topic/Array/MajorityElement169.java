package LeetCode.Topic.Array;

public class MajorityElement169 {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }
            if (nums[i] != candidate) {
                count--;
            } else {
                count++;
            }
        }
        return candidate;
    }
}
