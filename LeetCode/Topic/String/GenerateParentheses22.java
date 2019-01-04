package LeetCode.Topic.String;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        helper(n, n, new StringBuilder(), res);
        return res;
    }
    private void helper(int left, int right, StringBuilder sb, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        if (left > 0) {
            helper(left - 1, right, sb.append('('), res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            helper(left, right - 1, sb.append(')'), res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
