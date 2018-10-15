package C10_Recursion2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HaoYu on 2017/10/20.
 */
public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        // Write your solution here.
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(n, cur, res);
        return res;
    }
    private void helper(int n, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == n) {
            res.add(new ArrayList<>(cur));
            //TODO 需要new！
        }
        for (int i = 0; i < n; i++) {
            if (valid(cur, i)) {
                cur.add(i);
                helper(n, cur, res);
                cur.remove(cur.size() - 1);
            }
        }
    }
    private boolean valid (List<Integer> cur, int column) {
        int row = cur.size();
        for (int i  = 0; i < row; i++) {
            if (cur.get(i) == column || Math.abs(column - cur.get(i)) == row - i) {
                // TODO 这个其实就是判断斜率是否为1
                return false;
            }
        }
        return true;
    }
}
