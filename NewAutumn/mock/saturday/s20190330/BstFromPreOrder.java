package NewAutumn.mock.saturday.s20190330;

import util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class BstFromPreOrder {
    public TreeNode bstFromPreorder(int[] preorder) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        TreeNode root = null;
        for (int i = 0; i < preorder.length; i++) {
            TreeNode cur = new TreeNode(preorder[i]);
            if (i == 0) {
                root = cur;
            }
            while (!stack.isEmpty() && stack.peekFirst().val < preorder[i]) {
                pre = stack.pollFirst();
            }
            if (pre != null) {
                pre.right = cur;
            } else if (!stack.isEmpty()) {
                stack.peekFirst().left = cur;
            }
            stack.offerFirst(cur);
            pre = null;
        }
        return root;
    }
    public TreeNode buildBST (int[] array) {
        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        for (int i = 1; i < array.length; i++) {
            TreeNode cur = new TreeNode(array[i]);
            if (array[i] < stack.peekFirst().val) {
                stack.peekFirst().left = cur;
            } else {
                TreeNode parent  = stack.pollFirst();
                while (!stack.isEmpty() && stack.peekFirst().val < array[i]) {
                    parent = stack.pollFirst();
                }
                parent.right = cur;
            }
            stack.offerFirst(cur);
        }
        return root;
    }

}
