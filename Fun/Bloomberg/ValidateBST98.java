package Fun.Bloomberg;

import util.TreeNode;

public class ValidateBST98 {
    public boolean isValidBST(TreeNode root) {
        //TODO 讨论是否数值不会是MIN_VALUE或者MAX_VALUE
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val , max);
    }
}
