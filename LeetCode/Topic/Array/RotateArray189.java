package LeetCode.Topic.Array;

public class RotateArray189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int prev = i - k < 0 ? nums[nums.length - k + i] : nums[i - k];
            int current = i;
            int initial = 0;
            while (current != i || initial == 0) {
                initial = 1;
                int tmp = nums[current];
                nums[current] = prev;
                count++;
                current = (current + k) % nums.length;
                prev = tmp;
            }
        }
    }
}
