package Autumn.C5_Heap_BFS1;

import Autumn.C4_BST.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by HaoYu on 2017/10/4.
 */
public class BTisCompletedOrNot {
    public boolean isCompleted(TreeNode root) {
        // Write your solution here.
        if (root == null) {
            return true;
        }
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.left);
            }
            if (cur.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
