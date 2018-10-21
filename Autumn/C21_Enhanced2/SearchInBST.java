package Autumn.C21_Enhanced2;

import Autumn.C4_BST.TreeNode;

/**
 * Created by HaoYu on 2017/11/27.
 */
public class SearchInBST {
    public TreeNode search(TreeNode root, int key) {
        // Write your solution here.
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root.key == key) {
                return root;
            } else if (root.key < key) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return null;
    }
}
