package LeetCode;

import util.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumInBST653 {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }
    public boolean helper (TreeNode root, int k, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(root.val)) {
            return true;
        }
        set.add(k - root.val);
        return helper(root.left, k, set) || helper(root.right, k, set);
    }
}
