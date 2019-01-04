package LeetCode.Topic.Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 0; j < i - 1; j++) {
                cur.add(res.get(res.size() - 1).get(cur.size() - 1) + res.get(res.size() - 1).get(cur.size()));
            }
            if (i != 0) {
                cur.add(1);
            }
            res.add(new ArrayList<>(cur));
        }
        return res;
    }
}
