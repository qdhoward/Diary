package C24_Enhanced4;

import javax.naming.LinkLoopException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HaoYu on 2017/12/3.
 */
public class PermutationsOfParentheses2 {
    private static char[] parentheses = new char[] {'(', ')', '[', ']', '{', '}'};
    public List<String> validParentheses(int l, int m, int n) {
        // Write your solution here.
        int length = 2 * (l + m + n);
        int[] remains = new int[] {l, l, m, m, n, n};
        Deque<Character> stack = new LinkedList<>();
        List<String> res = new ArrayList<>();
        helper(remains, new StringBuilder(), res, length, stack);
        return res;
    }
    private void helper(int[] remain, StringBuilder sb, List<String> res, int length, Deque<Character> stack) {
        if (sb.length() == length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {
                if (remain[i] > 0) {
                    sb.append(parentheses[i]);
                    remain[i]--;
                    stack.offerFirst(parentheses[i + 1]);
                    helper(remain, sb, res, length, stack);
                    stack.pollFirst();
                    sb.deleteCharAt(sb.length() - 1);
                    remain[i]++;
                }
            } else {
                if (!stack.isEmpty() && parentheses[i] == stack.peekFirst()) {
                    //TODO 一种符号的话, 判断条件是right > left, 多种符号的话，用stack指示条件
                    sb.append(parentheses[i]);
                    remain[i]--;
                    stack.pollFirst();
                    helper(remain, sb, res, length, stack);
                    stack.offerFirst(parentheses[i]);
                    sb.deleteCharAt(sb.length() - 1);
                    remain[i]++;
                }
            }
        }
    }
}
