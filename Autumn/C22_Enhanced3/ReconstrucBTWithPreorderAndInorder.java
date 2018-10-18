package C22_Enhanced3;

import C4_BST.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HaoYu on 2017/12/2.
 */
public class ReconstrucBTWithPreorderAndInorder {
    public TreeNode reconstruct(int[] in, int[] pre) {
        // Write your solution here.
        Map<Integer, Integer> inIndex = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inIndex.put(in[i], i);
        }
        return helper(pre, inIndex, 0, in.length - 1, 0, pre.length - 1);
    }
    private TreeNode helper(int[] pre, Map<Integer, Integer> inIndex, int inLeft, int inRight, int preLeft, int preRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        int inMid = inIndex.get(pre[preLeft]);
        root.left = helper(pre, inIndex, inLeft, inMid - 1, preLeft + 1, preLeft + inMid - inLeft);
        root.right = helper(pre, inIndex, inMid + 1, inRight, preLeft + inMid - inLeft + 1, preRight);
        // 这些index需要好好想一下，当前子树（左或者右）是inleft到inright包括inright
        return root;
    }
    public static void main(String[] args){
        System.out.print(new ReconstrucBTWithPreorderAndInorder().reconstruct(new int[]{1,6,5,7,4,10,9}, new int[]{4,1,5,6,7,10,9}));
    }
}
