package Autumn.C4_BST;

import java.util.*;

/**
 * Created by HaoYu on 2017/12/1.
 */
public class PostOrder {
    public List<Integer> postOrder(TreeNode root) {
        // Write your solution here.
        //TODO 方法1 preorder是root左右，postorder是左右root，postorder的reverse是root右左
        List<Integer> postorder = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return postorder;
        }
        stack.offerFirst(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            if (cur.left != null) {
                stack.offerFirst(cur.left);
            }
            if (cur.right != null) {
                stack.offerFirst(cur.right);
            }
            postorder.add(cur.key);
        }
        Collections.reverse(postorder);
        return postorder;
    }
    public List<Integer> postOrder2(TreeNode root) {
        // Write your solution here.
        //TODO 方法2 记录prev，通过得到遍历过程中行走的方向来决定下一步
        List<Integer> postorder = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return postorder;
        }
        stack.offerFirst(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.peekFirst();
            if (prev == null || prev.left == cur || prev.right == cur) {
                // going down
                if (cur.left != null) {
                    stack.offerFirst(cur.left);
                } else if (cur.right != null) {
                    stack.offerFirst(cur.right);
                } else {
                    stack.pollFirst();
                    postorder.add(cur.key);
                }
            } else if (prev == cur.right || (prev ==  cur.left && cur.right == null)) {
                //TODO going up to parent, from right side or (from left side, but parent.right is null)
                stack.pollFirst();
                postorder.add(cur.key);
            } else {
                //going up to parent from left side and parent.right is null, so we have to traverse parent.right first
                stack.offerFirst(cur.right);
            }
            prev = cur;
        }
        return postorder;
    }
}
