package LeetCode.Topic.Tree;

import util.TreeNode;

public class BinaryTreeMaximumPathSum124 {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        res[0] = Integer.MIN_VALUE;
        helper(root, res);
        return res[0];
    }

    private int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, res);
        int right = helper(root.right, res);

        left = left < 0 ? 0 : left;
        right = right < 0 ? 0 : right;

        if (left + right + root.val > res[0]) {
            res[0] = left + right + root.val;
        }

        return left > right ? left + root.val : right + root.val;
    }

}
