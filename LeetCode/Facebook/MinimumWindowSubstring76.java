package LeetCode.Facebook;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {
    public String minWindow(String s, String t) {
        int slow  = 0;
        int fast = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            countMap.put(t.charAt(i), countMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int count = countMap.size();
        int res = Integer.MAX_VALUE;
        int leftIndex = 0;
        int rightIndex = -1;//TODO 注意初始条件
        //TODO [slow, fast] 表示的是符合条件的String
        while (fast < s.length()) {
            if (count != 0) {
                Integer curCount = countMap.get(s.charAt(fast));
                if (curCount != null) {
                    countMap.put(s.charAt(fast), curCount - 1);
                    if (countMap.get(s.charAt(fast)) == 0) {
                        count--;
                    }
                }
                while (slow < s.length() && count == 0) {
                    if (fast - slow + 1 < res) {
                        res = fast - slow + 1;
                        leftIndex = slow;
                        rightIndex = fast;
                    }
                    curCount = countMap.get(s.charAt(slow));
                    if (curCount != null) {
                        countMap.put(s.charAt(slow), curCount + 1);
                        if (countMap.get(s.charAt(slow)) == 1) {
                            count++;
                        }
                    }
                    slow++;
                }
            }
            fast++;
        }
        return s.substring(leftIndex, rightIndex + 1);
    }
    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring76().minWindow("a", "aa"));
    }
}
