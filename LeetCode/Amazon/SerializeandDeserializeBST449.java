package LeetCode.Amazon;

import apple.laf.JRSUIUtils;
import util.TreeNode;

public class SerializeandDeserializeBST449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        postOrder(root, sb);
        return sb.toString();
    }

    private void postOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.val);
        sb.append(',');
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] array = data.split(",");
        return helper(array, new int[] {array.length - 1}, Integer.MIN_VALUE);
    }

    private TreeNode helper(String[] data, int[] index, int min) {
        if (index[0] < 0 || getNumber(data[index[0]]) < min) {
            return null;
        }
        TreeNode root = new TreeNode(getNumber(data[index[0]--]));
        root.right = helper(data, index, root.val);
        root.left = helper(data, index, min);

        return root;
    }

    private int getNumber(String s) {
        return Integer.parseInt(s);
    }
}
