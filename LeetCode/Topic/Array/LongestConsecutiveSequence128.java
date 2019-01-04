package LeetCode.Topic.Array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128 {
    //TODO union find解法见UnionFindPractice2
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num-1)) {
                //TODO 时间复杂度实际上是O(n)，因为每个连续序列只会进if一次
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
