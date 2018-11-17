package NewAutumn.mock.saturday;

import util.KTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class s_11_17_2018 {
    //P1
    public int sumEquation(int[] array, int target) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] res = new int[1];
        helper(array, 0, target, res);
        return res[0];
    }
    private void helper(int[] array, int index, int target, int[] res) {
        if (index == array.length) {
            if (target == 0) {
                res[0] += 1;
            }
        }
        helper(array, index + 1, target + array[index], res);
        helper(array, index + 1, target - array[index], res);
    }

    public int sumEquation2(int[] array, int target) {
        if (array == null || array.length == 0) {
            return 0;
        }
        return helper2(array, 0, target, new int[array.length][target * 3]);
    }
    private int helper2(int[] array, int index, int target, int[][] dp) {
        if (index == array.length) {
            return target == 0 ? 1 : 0;
        }
        if (dp[index][target] != 0) {
            return dp[index][target];
        }
        int res = 0;
        res += helper2(array, index + 1, target + array[index], dp);
        res += helper2(array, index + 1, target - array[index], dp);
        dp[index][target] = res;
        return res;
    }

    //P2
    private static final char SPLITER = ',';

    private void preorder(KTreeNode root, StringBuilder sb) {
        sb.append(root.value);
        sb.append(SPLITER);
        sb.append(root.neighbors.size());
        sb.append(SPLITER);
        for (KTreeNode nei : root.neighbors) {
            preorder(nei, sb);
        }
    }

    private String serialize(KTreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private KTreeNode deserialize(Queue<String> queue) {
        KTreeNode root = new KTreeNode(Integer.parseInt(queue.poll()));
        int size = Integer.parseInt(queue.poll());
        for (int i = 0; i < size; i++) {
            root.neighbors.add(deserialize(queue));
        }
        return root;
    }

    //P4
    public List<List<Integer>> allFactors(int num) {
        if (num == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        allFactorsHelper(num, num, new ArrayList<>(), res);
        return res;
    }

    private void allFactorsHelper(int num, int lastFactor, List<Integer> curRes, List<List<Integer>> res) {
        if (num == 1) {
            res.add(new ArrayList<>(curRes));
        }
        for (int i = 2; i <= Math.min(lastFactor, num); i++) {//TODO math.min比较上个因子和当前数!!!!
            if (num % 2 == 0) {
                curRes.add(i);
                allFactorsHelper(num / i, i, curRes, res);
                curRes.remove(curRes.size() - 1);
            }
        }
    }
}
