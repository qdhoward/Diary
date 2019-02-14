package Fun.Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC4 {
    // count number of substrings with exactly k distinct characters
    public int count(String s, int k) {
        if (s == null || s.length() < k) {
            return 0;
        }
        int fast = 0;
        Map<Character, Integer> window = new HashMap<>();
        Set<Character> duplicate = new HashSet<>();
        int res = 0;
        while (fast < s.length()) {
            if (window.containsKey(s.charAt(fast))) {
                duplicate.add(s.charAt(fast));
            }
            window.put(s.charAt(fast), window.getOrDefault(s.charAt(fast), 0) + 1);
            if (fast >= k) {
                int count = window.get(s.charAt(fast - k));
                if (count == 2) {
                    duplicate.remove(s.charAt(fast - k));
                }
                window.put(s.charAt(fast), count - 1);
            }
            if (fast >= k - 1 && duplicate.size() == 0) {
                res++;
            }
            fast++;
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(new LC4().count("aaba", 2));
    }
}
