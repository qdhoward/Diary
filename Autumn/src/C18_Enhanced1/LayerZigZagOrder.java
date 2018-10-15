package C18_Enhanced1;

import C4_BST.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HaoYu on 2017/11/7.
 */
public class LayerZigZagOrder {
    public List<Integer> zigZag(TreeNode root) {
        // Write your solution here.
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                if (level % 2 != 0) {
                     TreeNode cur = queue.pollLast();
                     res.add(cur.key);
                     if (cur.right != null) {
                         queue.offerFirst(cur.right);
                     }
                     if (cur.left != null) {
                         queue.offerFirst(cur.left);
                     }
                } else {
                    TreeNode cur = queue.pollFirst();
                    res.add(cur.key);
                    if (cur.left != null) {
                        queue.offerLast(cur.left);
                    }
                    if (cur.right != null) {
                        queue.offerLast(cur.right);
                    }
                }
            }
            level++;//TODO first在左边还是右边不关键，只要全程在同一边就可以了
        }
        return res;
    }
}
