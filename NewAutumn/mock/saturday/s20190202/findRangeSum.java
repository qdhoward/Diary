package NewAutumn.mock.saturday.s20190202;

import util.TreeNode;

public class findRangeSum {
    public int findSumBST(TreeNode root, int left, int right) {
        int[] sum = new int[1];
        sumBST(root, left, right, sum);
        return sum[0];
    }

    private void sumBST(TreeNode root, int left, int right, int[] sum) {
        if (root == null) {
            return;
        }
        if (root.val < right && root.val > left) {
            sum[0] += root.val;
            sumBST(root.left, left, right, sum);
            sumBST(root.right, left, right, sum);
        } else if (root.val >= right) {
            if (root.val == right) {
                sum[0] += root.val;
            }
            sumBST(root.left, left, right, sum);
        } else {
            if (root.val == left) {
                sum[0] += root.val;
            }
            sumBST(root.right, left, right, sum);
        }
    }
}
