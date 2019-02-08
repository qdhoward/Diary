package LeetCode.Topic.Tree;

import util.TreeNode;

public class CountUnivalueSubtrees {
    public int countUnivalSubtrees(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }

    private Integer helper(TreeNode root, int[] res) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            res[0]++;
            return root.val;
        }
        if (root.left == null || root.right == null) {
            if (root.left == null) {
                Integer right = helper(root.right, res);
                if (right != null && right.equals(root.val)) {
                    res[0]++;
                    return root.val;
                } else {
                    return null;
                }
            } else {
                Integer left = helper(root.left, res);
                if (left != null && left.equals(root.val)) {
                    res[0]++;
                    return root.val;
                } else {
                    return null;
                }
            }
        }
        Integer left = helper(root.left, res);
        Integer right = helper(root.right, res);
        if (left == null || right == null) {
            return null;
        }
        if (left.equals(right) && right.equals(root.val)) {
            res[0]++;
            return root.val;
        }
        return null;
    }
}
