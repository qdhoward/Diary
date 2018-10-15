package C22_Enhanced3;

import C4_BST.TreeNode;
import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HaoYu on 2017/12/3.
 */
public class ReconstructBTWithLevelorderAndInorder {
    public TreeNode reconstruct(int[] in, int[] level) {
        // Write your solution here.
        Map<Integer, Integer> inIndex = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inIndex.put(in[i], i);
        }
        List<Integer> newLevel = new ArrayList<Integer>();
        for (int i = 0; i < level.length; i ++) {
            newLevel.add(level[i]);
        }
        return helper(in, newLevel, inIndex, 0, in.length - 1);
    }
    private TreeNode helper(int[] in, List<Integer> level, Map<Integer, Integer> inIndex, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(level.remove(0));
        //TODO 这个地方必须写成remove，不能写成get! 因为你下面要把当前level过一遍，分别加到左右level上。
        //TODO 如果不删除的话，level第一个数值会一直在，stackoverflow了！
        int inMid = inIndex.get(root.key);
        List<Integer> leftLevel = new ArrayList<>();
        List<Integer> rightLevel = new ArrayList<>();
        for (int num : level) {
            if (inIndex.get(num) < inMid) {
                leftLevel.add(num);
            } else {
                rightLevel.add(num);
            }
        }
        root.left = helper(in, leftLevel, inIndex, inLeft, inMid - 1);
        root.right = helper(in, rightLevel, inIndex, inMid + 1, inRight);
        return root;
    }
    public static void main(String[] args){
        System.out.print(new ReconstructBTWithLevelorderAndInorder().reconstruct(new int[]{1,2,3,4,11,6},new int[]{3,1,6,2,4,11}));
    }
}
