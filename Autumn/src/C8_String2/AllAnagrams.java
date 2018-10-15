package C8_String2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HaoYu on 2017/10/20.
 */
public class AllAnagrams {
    public List<Integer> allAnagrams(String s, String l) {
        // Write your solution here.
        List<Integer> res = new ArrayList<Integer>();
        if (l.length() == 0 || s.length() > l.length()) {
            return res;
        }
        Map<Character, Integer> count = new HashMap<>();
        int match = 0;
        for (char ch : s.toCharArray()) {
            Integer num = count.get(ch);
            //TODO 先get这样后续可以省一次查询，因为如此所以num必须是Integer（int无法判断null）
            if (num != null) {
                count.put(ch, num + 1);
            } else {
                count.put(ch, 1);
            }
        }
        for (int i = 0; i < l.length(); i++) {
            char tmp = l.charAt(i);
            Integer num = count.get(tmp);
            if (num != null) {
                count.put(tmp, num - 1);
                if (num == 1) {
                    match++;
                }
            }
            if (i >= s.length()) {
                tmp = l.charAt(i - s.length());
                num = count.get(tmp);
                if (num != null) {
                    count.put(tmp, num + 1);
                    if (num == 0) {
                        match--;
                    }
                }
            }
            if (match == count.size()) {
                res.add(i - s.length() + 1);
            }
        }
        return res;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if (s.length() == 0 || p.length() > s.length()) {
            return res;
        }
        int match = 0;
        Map<Character, Integer> count = countMap(s);
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            Integer num = count.get(tmp);
            if (num != null) {
                count.put(tmp, num - 1);
                if (num == 1) {
                    match++;
                }
            }
            if (i >= p.length()) {
                tmp = s.charAt(i - p.length());
                num = count.get(tmp);
                if (num != null) {
                    count.put(tmp, num + 1);
                    if (num == 0) {
                        match--;
                    }
                }
            }
            if (match == count.size()) {
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
    private Map<Character, Integer> countMap(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer num = count.get(c);
            if (num == null) {
                count.put(c, 1);
            } else {
                count.put(c, num + 1);
            }
        }
        return count;
    }
    public static void main(String[] args){
//        System.out.print(new AllAnagrams().allAnagrams("abc", "cbaebabacd"));
        System.out.print(new AllAnagrams().findAnagrams("abc", "cbaebabacd"));
    }
}
