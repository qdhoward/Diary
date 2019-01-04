package LeetCode.Topic.Array;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTfromPreorderAndInorder105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return helper(preorder, indexMap, 0, inorder.length - 1, 0, preorder.length - 1);
    }
    private TreeNode helper(int[] preorder, Map<Integer, Integer> indexMap, int inLeft, int inRight, int preLeft, int preRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int inMid = indexMap.get(preorder[preLeft]);
        root.left = helper(preorder, indexMap, inLeft, inMid - 1, preLeft + 1, preLeft + inMid - inLeft);
        root.right = helper(preorder, indexMap, inMid + 1, inRight, preLeft + inMid - inLeft + 1, preRight);
        return root;
    }
}
