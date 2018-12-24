package LeetCode.Company.Facebook;

import util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class BSTIterator173 {
    private Deque<TreeNode> stack;
    public BSTIterator173(TreeNode root) {
        stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode next = stack.pop();
        TreeNode cur = next;
        if (cur.right != null) {
            cur = cur.right;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }
        return next.val;
    }
}
