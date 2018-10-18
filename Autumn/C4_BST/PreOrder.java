package Autumn.C4_BST;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HaoYu on 2017/12/1.
 */
public class PreOrder {
    public List<Integer> preOrder(TreeNode root) {
        // Write your solution here.
        List<Integer> preorder = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return preorder;
        }
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            preorder.add(cur.key);
        }
        return preorder;
    }
}
