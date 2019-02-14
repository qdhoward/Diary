package Fun.Amazon;

import java.util.HashSet;
import java.util.Set;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int res = 0;
        while (fast < s.length()) {
            if (!set.contains(s.charAt(fast))) {
                set.add(s.charAt(fast));
                fast++;
                res = Math.max(res, fast - slow); //fast已经移动了，所以无需+1
            } else {
                set.remove(s.charAt(slow));
                slow++;
            }
        }
        return res;
    }
}
