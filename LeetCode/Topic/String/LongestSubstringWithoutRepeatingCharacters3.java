package LeetCode.Topic.String;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> distinct = new HashSet<>();
        int fast = 0;
        int slow = 0;
        int length = 0;
        while (fast < s.length()) {
            if (!distinct.contains(s.charAt(fast))) {
                distinct.add(s.charAt(fast++));
            } else {
                distinct.remove(s.charAt(slow++));
            }
            length = Math.max(length, fast - slow);
        }
        return length;
    }
}
