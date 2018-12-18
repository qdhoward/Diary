package LeetCode.Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation150 {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int prev = stack.pop();
                int prev2 = stack.pop();
                stack.push(prev2 + prev);
            } else if (tokens[i].equals("-")) {
                int prev = stack.pop();
                int prev2 = stack.pop();
                stack.push(prev2 - prev);
            } else if (tokens[i].equals("*")) {
                int prev = stack.pop();
                int prev2 = stack.pop();
                stack.push(prev2 * prev);
            } else if (tokens[i].equals("/")) {
                int prev = stack.pop();
                int prev2 = stack.pop();
                stack.push(prev2 / prev);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
