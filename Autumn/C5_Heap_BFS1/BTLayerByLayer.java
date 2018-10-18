package Autumn.C5_Heap_BFS1;

import Autumn.C3_LinkedList.ListNode;
import Autumn.C4_BST.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by HaoYu on 2017/10/4.
 */

public class BTLayerByLayer {
    public List<List<Integer>> layerByLayer(TreeNode root) {
        // Write your solution here.
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLayer = new ArrayList<>();
            //TODO 记住JAVA里面每个new出来的都只作用于当前{},{如果你把curLayer new在for里面，是不对的。
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curLayer.add(cur.key);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            res.add(curLayer);
        }
        return res;
    }
}
