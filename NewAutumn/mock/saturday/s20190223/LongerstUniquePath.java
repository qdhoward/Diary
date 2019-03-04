package NewAutumn.mock.saturday.s20190223;

import util.TreeNode;

public class LongerstUniquePath {
    public int find(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }
    private int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        int leftCount = helper(root.left, res);
        int rightCount = helper(root.right, res);
        int left = 0;
        int right = 0;
        if (root.left != null && root.val == root.left.val) {
            left += leftCount;
        }
        if (root.right != null && root.val == root.right.val) {
            right += rightCount;
        }
        res[0] = Math.max(left + right + 1, res[0]);
        return Math.max(left, right) + 1;
    }
}
