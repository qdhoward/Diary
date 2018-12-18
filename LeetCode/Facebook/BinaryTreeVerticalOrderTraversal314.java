package LeetCode.Facebook;

import util.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal314 {
    private int min = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> columns = new LinkedList<>();
        queue.offer(root);
        columns.offer(0);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            int curColumn = columns.poll();
            if (!map.containsKey(curColumn)) {
                map.put(curColumn, new ArrayList<>());
            }
            map.get(curColumn).add(cur.val);
            if (cur.left != null) {
                min = Math.min(min, curColumn - 1);
                queue.offer(cur.left);
                columns.offer(curColumn - 1);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                columns.offer(curColumn + 1);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (map.containsKey(min)) {
            res.add(map.get(min));
            min++;
        }
        return res;
    }
}
