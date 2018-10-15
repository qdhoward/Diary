package Midterm2;

import C4_BST.TreeNode;

/**
 * Created by HaoYu on 2017/11/14.
 */
public class MaxSumSubtree {
    public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        helper(root, max);
        return max[0];
    }

    private int helper (TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        if (root.left != null && root.right != null) {
            //TODO 这么写是考虑有可能形不成回路，比如new String[]{"1","2","#","3","#","#","4"}
            max[0] = Math.max(left + right + root.key, max[0]);
            return left > right ? left + root.key : right + root.key;
        }
        return root.left == null ? right + root.key : left + root.key;
    }
}
