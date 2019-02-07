package LeetCode.Topic.Tree;

import util.TreeNode;

public class DiameterofBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        helper(root, res);
        return res[0] - 1;
    }

    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);

        max[0] = left + right + 1 > max[0] ? left + right + 1 : max[0];

        return left > right ? left + 1: right + 1;
    }
}
