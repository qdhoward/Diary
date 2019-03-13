package Fun.Amazon;


import util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class TreeTraversals {
    public void preOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            System.out.println(cur.val);
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
        }
    }

    public void inOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode helper = root;
        while (!stack.isEmpty() || helper != null) {
            if (helper != null) {
                stack.offerFirst(helper);
                helper = helper.left;
            } else {
                helper = stack.peekFirst();
                System.out.println(helper.val);
                helper = helper.right;
            }
        }
    }

    public void postOrder(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode helper = root;
        while (!stack.isEmpty() || helper != null) {
            if (helper != null) {
                stack.offerFirst(helper);
                helper = helper.left;
            } else {
                helper = stack.peekFirst();
                System.out.println(helper.val);
                helper = helper.right;
            }
        }
    }
}
