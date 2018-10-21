package Autumn.C22_Enhanced3;

import Autumn.C4_BST.TreeNode;

/**
 * Created by HaoYu on 2017/12/2.
 */
public class MaximumPathSumBinaryTree3 {
    public int maxPathSum(TreeNode root) {
        // Write your solution here.
        // From any node to any node
        int[] max = new int[] {Integer.MIN_VALUE};
        helper(root, 0, max);
        return max[0];
    }
    private void helper(TreeNode root, int sum, int[] max) {
        if (root == null) {
            return;
        }
        //TODO 其实就是一个DP的max subarray,只不过是通过树来表示的
        if (sum < 0) {
            sum = root.key;
        } else {
            sum += root.key;
        }
        max[0] = Math.max(max[0], sum);
        helper(root.left, sum, max);
        helper(root.right, sum, max);
    }

    private int helper2(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        //TODO 自下而上返回值, 其实也是dp
        int left = helper2(root.left, max);
        int right = helper2(root.right, max);
        if (Math.max(left, right) < 0) {
            max[0] = Math.max(max[0], root.key);
            return root.key;
        } else {
            int tmp = Math.max(left, right) + root.key;
            max[0] = Math.max(max[0], tmp);
            return tmp;
        }
    }
}
