package Midterm2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HaoYu on 2017/11/14.
 */
public class NQueens {
    public List<List<Integer>> nqueens(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        helper(n, res, new ArrayList<>());
        return res;
    }
    private void helper(int n, List<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == n) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (valid(cur, i)) {
                cur.add(i);
                helper(n, res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
    private boolean valid(List<Integer> cur, int row) {
        for (int i = 0; i < cur.size(); i++) {
            if (cur.get(i) == row || cur.size() - i == Math.abs(row - cur.get(i))) {
                return false;
            }
        }
        return true;
    }
}
