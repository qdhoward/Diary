package C21_Enhanced2;

import C4_BST.TreeNode;

/**
 * Created by HaoYu on 2017/11/26.
 */
public class ClosestNumberInBST {
    public int closest(TreeNode root, int target) {
        // Write your solution here.
        TreeNode cur = root;
        int res = root.key;
        while (cur != null) {
            if (cur.key == target) {
                return cur.key;
            } else if (Math.abs(cur.key - target) < Math.abs(res - target)) {
                res = cur.key;
            }
            if (cur.key < target) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return res;
    }
}
