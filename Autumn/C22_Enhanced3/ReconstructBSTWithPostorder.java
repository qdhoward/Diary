package Autumn.C22_Enhanced3;

import Autumn.C4_BST.TreeNode;

/**
 * Created by HaoYu on 2017/12/2.
 */
public class ReconstructBSTWithPostorder {
    public TreeNode reconstruct(int[] post) {
        // Write your solution here.
        //TODO 注意，本题是BST，所以后序遍历可以唯一确定。如果是BT的话，不能唯一确定
        int[] index = new int[] {post.length - 1};
        return helper(post, index, Integer.MIN_VALUE);
    }
    private TreeNode helper(int[] post, int[] index, int min) {
        if (index[0] < 0 || post[index[0]] <= min) {
            return null;
        }
        TreeNode curroot = new TreeNode(post[index[0]]);
        index[0] = index[0] - 1;
        curroot.right = helper(post, index, curroot.key);
        curroot.left = helper(post, index, min);
        return curroot;
    }
}
