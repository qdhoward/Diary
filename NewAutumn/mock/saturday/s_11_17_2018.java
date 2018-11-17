package NewAutumn.mock.saturday;

import util.KTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class s_11_17_2018 {
    //P1
    public int sumEquation(int[] array, int target) {
        //Time O(2^n) Space O(n)
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
        //Time O(n * target) ? Space O(n * target)
        if (array == null || array.length == 0) {
            return 0;
        }
        //TODO offset is related to sumOf Target! 相当于一直加
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
    //Time O(V + E) Space O(height)
    private static final char SPLITTER = ',';
    private void preorder(KTreeNode root, StringBuilder sb) {
        sb.append(root.value);
        sb.append(SPLITTER);
        sb.append(root.neighbors.size());
        sb.append(SPLITTER);
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
    //Time O(num!) Space O(num)
    public List<List<Integer>> allFactors(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        allFactorsHelper(n, n - 1, new ArrayList<>(), res);//TODO 不包括 1 和 num本身，所以传入n - 1
        return res;
    }

    private void allFactorsHelper(int num, int lastFactor, List<Integer> curRes, List<List<Integer>> res) {
        if (num == 1) {
            res.add(new ArrayList<>(curRes));
        }
        for (int i = 2; i <= Math.min(lastFactor, num); i++) {//TODO math.min比较上个因子和当前数!!!!
            if (num % i == 0) {
                curRes.add(i);
                allFactorsHelper(num / i, i, curRes, res);
                curRes.remove(curRes.size() - 1);
            }
        }
    }
}
