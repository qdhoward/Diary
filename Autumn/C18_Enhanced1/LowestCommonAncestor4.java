package C18_Enhanced1;

import Autumn.C4_BST.TreeNode;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by HaoYu on 2017/11/7.
 */
public class LowestCommonAncestor4 {
    public TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
        // Write your solution here.
        Set<TreeNode> set = new HashSet<>(nodes);
        return helper(root, set);
    }
    private TreeNode helper(TreeNode root, Set<TreeNode> set) {
        if (root == null || set.contains(root)) {
            return root;
        }
        TreeNode left = helper(root.left, set);
        TreeNode right = helper(root.right, set);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
