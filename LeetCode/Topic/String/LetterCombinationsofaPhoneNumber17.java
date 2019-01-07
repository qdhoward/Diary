package LeetCode.Topic.String;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] map = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        helper(res, new StringBuilder(), digits, 0, map);
        return res;
    }

    private void helper (List<String> res, StringBuilder cur, String digits, int index, String[] map) {
        if (index == digits.length()) {
            res.add(cur.toString());
            return;
        }
        int digit = digits.charAt(index) - '0';
        for (int i = 0; i < map[digit].length(); i++) {
            helper(res, cur.append(map[digit].charAt(i)), digits, index + 1, map);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
