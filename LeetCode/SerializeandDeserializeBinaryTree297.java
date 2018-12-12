package LeetCode;

import org.omg.PortableInterceptor.INACTIVE;
import util.KTreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree297 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static final char SPLITTER = ',';
    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null");
            return;
        }
        sb.append(root.val);
        sb.append(SPLITTER);
        preorder(root.left, sb);
        sb.append(SPLITTER);
        preorder(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private Queue<String> generateQueue(String data) {
        Queue<String> queue = new ArrayDeque<>();
        if (data == null || data.length() == 0) {
            return queue;
        }
        String[] array = data.split(",");
        for (int i = 0; i < array.length; i++) {
            queue.offer(array[i]);
         }
        return queue;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = generateQueue(data);
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        if (queue.size() == 0) {
            return null;
        }
        String cur = queue.poll();
        if (cur.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
}
