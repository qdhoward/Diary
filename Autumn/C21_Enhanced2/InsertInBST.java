package Autumn.C21_Enhanced2;

import Autumn.C4_BST.TreeNode;

/**
 * Created by HaoYu on 2017/11/27.
 */
public class InsertInBST {
    public TreeNode insert (TreeNode root, int key) {
        //TODO recursive 写法
        if (root == null) {
            return new TreeNode(key);
        }
        if (root.key == key) {
            return root;
        } else if (root.key > key) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public TreeNode insert2(TreeNode root, int key) {
        //TODO Iterative 写法
        // Write your solution here.
        if (root == null) {
            return new TreeNode(key);
        }
        TreeNode cur = root;
        TreeNode parent = root;
        while (cur != null) {
            if (cur.key == key) {
                return root;
            } else if (cur.key > key) {
                parent = cur;
                cur = cur.left;
            } else {
                parent = cur;
                cur = cur.right;
            }
        }
        if (parent.key > key) {
            parent.left = new TreeNode(key);
        } else {
            parent.right = new TreeNode(key);
        }
        return root;
    }
}
