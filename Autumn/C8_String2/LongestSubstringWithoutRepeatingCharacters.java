package C8_String2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HaoYu on 2017/10/19.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int longest(String input) {
        // Write your solution here.
        int slow = 0;
        int fast = 0;
        int length = 0;
        Set<Character> distinct = new HashSet<>();
        while (fast < input.length()) {
            if (!distinct.contains(input.charAt(fast))) {
                distinct.add(input.charAt(fast++));
                length = Math.max(length, fast - slow);
                // TODO 不需要 +1 因为fast是先移动后判断！
            } else {
                distinct.remove(input.charAt(slow++));
            }
        }
        return length;
    }
}
