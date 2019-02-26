package NewAutumn.mock.saturday.s20190216;

import java.util.ArrayList;
import java.util.List;

public class FIndAllCombination {
    public List<List<Integer>> find(int s, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (s * 9 < n) {
            return res;
        }
        helper(s, 0, n, res, new ArrayList<>());
        return res;
    }

    public void helper(int s, int last, int remaining, List<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == s) {
            if (remaining == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        //关键在于i=last+1, 去重
        for (int i = last + 1; i < 10; i++) {
            cur.add(i);
            helper(s, i,remaining - i, res, cur);
            cur.remove(cur.size() - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println(
                new FIndAllCombination().find(3, 7)
        );
    }
}
