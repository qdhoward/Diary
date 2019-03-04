package NewAutumn.mock.saturday.s20190302;

import util.TreeNode;

public class MaxPathSumNodeToNode {
    int findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }
    private int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int curMax = root.val;

        if (left > 0) {
            curMax += left;
        }
        if (right > 0) {
            curMax += right;
        }
        res[0] = Math.max(res[0], curMax);
        return Math.max(Math.max(left, right) + root.val, 0);
    }
}
