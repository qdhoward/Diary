package Autumn.C4_BST;

/**
 * Created by HaoYu on 2017/10/3.
 */
public class isBSTorNot {
    public boolean isBST(TreeNode root) {
        // Write your solution here.
        if (root == null) {
            return true;
        }
        return isBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    private boolean isBST(TreeNode root, int max, int min){
        if (root == null) {
            return true;
        } else if (root.key <= min || root.key >=max){
            return false;
        }
        return isBST(root.left, root.key, min) && isBST(root.right, max, root.key);
    }
}
