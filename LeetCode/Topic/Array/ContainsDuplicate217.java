package LeetCode.Topic.Array;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        Set countSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!countSet.add(nums[i])) {
                return false;
            }
        }
        return false;
    }
}
