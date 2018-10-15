package C4_BST;

import apple.laf.JRSUIUtils;

import java.time.temporal.Temporal;

/**
 * Created by HaoYu on 2017/10/2.
 */
public class ChcekIfBalanced {
    public boolean isBalanced(TreeNode root) {
        //TODO method2 O(n)
        if (helper(root) == - 1) {
            return false;
        } else {
            return true;
        }
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left - right) > 1 || left == -1 || right == -1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        // Write your solution here.
        if (root == null) {
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(Math.abs(left - right) > 1){
            return false;
        }
        return isBalanced2(root.left) && isBalanced2(root.right);
    }
    private int getHeight(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        return Math.max(left, right) + 1;
    }
}
