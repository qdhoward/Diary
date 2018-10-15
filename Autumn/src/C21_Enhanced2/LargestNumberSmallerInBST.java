package C21_Enhanced2;

import C4_BST.TreeNode;

/**
 * Created by HaoYu on 2017/11/27.
 */
public class LargestNumberSmallerInBST {
    public int largestSmaller(TreeNode root, int target) {
        // Write your solution here.
        int res = Integer.MIN_VALUE;
        while (root != null) {
            if (root.key >= target) {
                root = root.left;
            } else {
                res = root.key;//TODO 防止NPE，先赋值
                root = root.right;
            }
        }
        return res;
    }
}
