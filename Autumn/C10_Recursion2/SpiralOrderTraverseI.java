package C10_Recursion2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HaoYu on 2017/10/20.
 */
public class SpiralOrderTraverseI {
    public List<Integer> spiral(int[][] matrix) {
        // Write your solution here.
        List<Integer> res = new ArrayList<>();
        helper(matrix, 0, matrix.length, res);
        return res;
    }
    private void helper(int[][] matrix, int offset, int size, List<Integer> res) {
        if (size == 0) {
            return;
        }
        if (size == 1) {
            res.add(matrix[offset][offset]);
            return;
        }
        // TODO 其实每次循环的次数都是固定的，都是size - 1次，我们只需要在i的基础上用offset表示坐标就可以了
        for (int i = 0; i < size - 1; i++) {
            res.add(matrix[offset][offset + i]);
        }
        for (int i = 0; i < size - 1; i++) {
            res.add(matrix[i + offset][size - 1 + offset]);
        }
        for (int i = size - 1; i >= 1; i++) {
            res.add(matrix[size - 1 + offset][i + offset]);
        }
        for (int i = size - 1; i >= 1; i++) {
            res.add(matrix[offset + i][offset]);
        }
        helper(matrix, offset + 1, size - 2, res);
    }
}
