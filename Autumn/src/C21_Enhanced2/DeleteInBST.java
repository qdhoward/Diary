package C21_Enhanced2;

import C4_BST.TreeNode;
import apple.laf.JRSUIUtils;

/**
 * Created by HaoYu on 2017/11/27.
 */
public class DeleteInBST {
    public TreeNode delete(TreeNode root, int key) {
        // Write your solution here.
        if (root == null) {
            return null;
        }
        if (root.key < key) {
            root.right = delete(root.right, key);
        } else if (root.key > key) {
            root.left = delete(root.left, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null || root.right == null) {
                return root.left == null ? root.right : root.left;
            } else {
                TreeNode smallest= findSmallest(root.right);
                root.key = smallest.key;
                root.right = delete(root.right, smallest.key);
                //TODO 不能写成delete(root.right, smallest.key)！！！
            }
        }
        return root;
    }
    private TreeNode findSmallest (TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
