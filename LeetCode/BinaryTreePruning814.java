package LeetCode;

import util.TreeNode;

public class BinaryTreePruning814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root);
        return root;
    }
     private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == 0) {
            root.left = null;
        }
        if (right == 0) {
            root.right = null;
        }
        if (left == 1 || right == 1 || root.val == 1) {
            return 1;
        } else {
            return 0;
        }
     }
}
