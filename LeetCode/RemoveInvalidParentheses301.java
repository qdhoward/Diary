package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, 0, res, new char[] {'(', ')'});
        if (res.size() == 0) {
            res.add("");
        }
        return res;
    }
    private void helper (String s, int start, int last, List<String> res, char[] tool) {
        int count = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == tool[0]) {
                count++;
            } else if (s.charAt(i) == tool[1]) {
                count--;
            }   //)((
            if (count < 0) {
                for (int j = last; j <= i; j++) {
                    if (s.charAt(j) == tool[1] && (j == 0 || s.charAt(j - 1) != tool[1])) {
                        String tmp = s.substring(0, j) + s.substring(j + 1, s.length());
                        helper(tmp, i, j, res, tool);
                    }
                }
                return;
                //TODO 此处return很重要！当前层处理完之后直接return，后续的也已经在下面层处理完了。
            }
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (tool[0] == '(') {
            helper(reversed, 0, 0, res, new char[]{')', '('});
        } else {
            res.add(reversed);
        }
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses301 test = new RemoveInvalidParentheses301();

        System.out.println(test.removeInvalidParentheses(")(("));
    }
}
