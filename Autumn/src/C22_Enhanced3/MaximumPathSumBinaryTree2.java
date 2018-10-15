package C22_Enhanced3;

import C4_BST.TreeNode;

import javax.management.relation.InvalidRelationTypeException;

/**
 * Created by HaoYu on 2017/12/2.
 */
public class MaximumPathSumBinaryTree2 {
    public int maxPathSum(TreeNode root) {
        // Write your solution here.
        int[] max = new int[] {Integer.MIN_VALUE}; //TODO 这个初始化千万别忘了！否则默认max=0
        helper(root, max);
        return max[0];
    }
    private int helper(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, max);
        int right = helper(root.right, max);
        if (left < 0) {
            left = 0;
        }
        if (right < 0) {
            right = 0;
        }
        max[0] = Math.max(max[0], left + right + root.key);
        return Math.max(left, right) + root.key;
    }
}
