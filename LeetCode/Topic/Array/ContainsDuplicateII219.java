package LeetCode.Topic.Array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer prev = visited.get(nums[i]);
            if (prev == null || i - prev > k) {
                visited.put(nums[i], i);
            } else if (i - prev <= k) {
                return true;
            }

        }
        return false;
    }
}
