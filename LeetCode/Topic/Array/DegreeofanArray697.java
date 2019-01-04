package LeetCode.Topic.Array;

import java.util.HashMap;
import java.util.Map;

public class DegreeofanArray697 {
    public int findShortestSubArray(int[] nums) {
        int[] count = new int[50000];
        int[] index = new int[50000];
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            max = Math.max(count[nums[i]], max);
            index[nums[i]] = i;
        }
        //TODO 跟踪记录最右边的坐标，同一个数找过一次后不再找了
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (count[nums[i]] == max && count[nums[i]] != -1) {
                res = Math.min(res, index[nums[i]] - i + 1);
                count[nums[i]] = -1;
            }
        }
        return res;
    }
}
