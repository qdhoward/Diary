package C4_BST;

import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * Created by HaoYu on 2017/10/3.
 */
public class GetKeyinBSTinRange {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        // Write your solution here.
        List<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        getrange(root, min, max, res);// void就可以，res会更改
        return res;
    }
    private void getrange(TreeNode root, int min, int max, List<Integer> res){
        if (root == null) {
            return;
        }
        if (root.key > min) { //为了保证顺序排列，要先找到最小的。
            getrange(root.left, min, max, res);
        }
        if (root.key >= min && root.key <= max) {
            res.add(root.key);
        }
        if (root.key < max) { //为了保证顺序排列，找到最小的后还要遍历最小的右子树。
            getrange(root.right, min, max, res);
        }
    }
}
