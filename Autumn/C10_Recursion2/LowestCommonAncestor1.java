package Autumn.C10_Recursion2;

import Autumn.C4_BST.TreeNode;

/**
 * Created by HaoYu on 2017/10/21.
 */
public class LowestCommonAncestor1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
        // Write your solution here.
        if (root == null) {
            return null;
        }
        if (root == one || root == two) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, one, two);
        TreeNode right = lowestCommonAncestor(root.right, one, two);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
    //TODO follow up 如果one or two不在tree里，要考虑四种情况
    //TODO k叉树找m个node的共同祖先
}
