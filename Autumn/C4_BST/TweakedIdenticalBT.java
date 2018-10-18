package Autumn.C4_BST;

/**
 * Created by HaoYu on 2017/10/3.
 */
public class TweakedIdenticalBT {
    public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
        // Write your solution here.
        if (one == null && two == null) {
            return true;
        } else if (one == null || two == null) {
            return false;
        } else if (one.key != two.key) {
            return false;
        }
        return isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left) ||
                isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right);
    }
}
