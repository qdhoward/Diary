package LeetCode.Facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContinuousSubarraySum523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        Set<Integer> preSum = new HashSet<>();
        int prefixSum = nums[0];
        int prefixSum2 = 0;
        preSum.add(0);
        for (int i = 1; i < nums.length; i++) {
            //TODO 要考虑k=0的情况
            if (k != 0 && i >= 2) {
                prefixSum2 += nums[i - 2];
                preSum.add(prefixSum2 % k);
            } else if (k == 0 && i >= 2) {
                prefixSum2 += nums[i - 2];
                preSum.add(prefixSum2);
            }
            //TODO 要先加再判断！！！！
            prefixSum += nums[i];
            if (k != 0 && preSum.contains(prefixSum % k)) {
                return true;
            } else if (k == 0 && preSum.contains(prefixSum)){
                return true;
            }
        }
        return false;
    }
}
