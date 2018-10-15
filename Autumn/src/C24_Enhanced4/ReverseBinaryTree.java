package C24_Enhanced4;

import C4_BST.TreeNode;

/**
 * Created by HaoYu on 2017/12/3.
 */
public class ReverseBinaryTree {
    public TreeNode reverse(TreeNode root) {
        // Write your solution here.
        if (root == null || root.left == null) {
            return root;
        }
        //TODO 不能写成return null!!!
        TreeNode newRoot = reverse(root.left);
        root.left.left = root;
        root.left.right = root.right;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
