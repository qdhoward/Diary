package Autumn.C6_DFS1;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HaoYu on 2017/10/5.
 */
public class PermutationsOfParentheses1 {
    public List<String> validParentheses(int n) {
        // Write your solution here.
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        DFS(n, n, res, sb);
        return res;
    }
    private void DFS(int left, int right, List<String> res, StringBuilder sb) {
        //TODO 用char[]代替StringBuilder, 用index来指示append，这样backtrack的时候自动删除，kindof
        if(left == 0 && right == 0) {
            res.add(sb.toString());
        }
        if (left > 0) {
            sb.append('(');
            DFS(left - 1, right, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            sb.append(')');
            DFS(left, right - 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        System.out.print(new PermutationsOfParentheses1().validParentheses(3));
    }
}
