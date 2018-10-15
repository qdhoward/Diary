package C4_BST;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HaoYu on 2017/12/1.
 */
public class InOrder {
    public List<Integer> inOrder(TreeNode root) {
        // Write your solution here.
        List<Integer> inorder = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return inorder;
        }
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // TODO 必须是或！不能是&&！一开始的时候stack是空的！
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                inorder.add(cur.key);
                cur = cur.right;
            }
        }
        return inorder;
    }
}
