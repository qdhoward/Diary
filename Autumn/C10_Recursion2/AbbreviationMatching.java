package C10_Recursion2;

/**
 * Created by HaoYu on 2017/10/20.
 */
public class AbbreviationMatching {
    public boolean match(String input, String pattern) {
        // Write your solution here.
        return match(input, pattern, 0, 0);
    }
    private boolean match(String input, String pattern, int is, int ps) {
        // TODO 这道题是一个很好的递归return结果的例子，每次递归都是return调用
        if (is == input.length() && ps == pattern.length()) {
            return true;
        }
        if (is >= input.length() || ps >= pattern.length()) {
            return false;
        }
        if (pattern.charAt(ps) > '9' || pattern.charAt(ps) < '0') {
            if (pattern.charAt(ps) == input.charAt(is)) {
                return match(input, pattern, is + 1, ps + 1);
            } else {
                return false;
            }
        }
        int number = 0;
        while (ps < pattern.length() && pattern.charAt(ps) <= '9' && pattern.charAt(ps) >= '0') {
            number = 10 * number + (pattern.charAt(ps) - '0');
            ps++;
        }
        return match(input, pattern, is + number, ps);
    }
}
