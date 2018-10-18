package C22_Enhanced3;

import C4_BST.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by HaoYu on 2017/12/2.
 */
public class BinaryTreePathSumToTarget2 {
    public boolean exist(TreeNode root, int target) {
        // Write your solution here.
        if (root == null) {
            return false;
        }
        Set<Integer> prefixSum = new HashSet<Integer>();
        int presSum = 0;
        prefixSum.add(0);//TODO 这个必须加！想想two sum! 其实就是任何prevSum都得加，包括初始值
        return helper(root, prefixSum,presSum, target);
    }
    private boolean helper(TreeNode root, Set<Integer> prefixSum, int prevSum, int target) {
        prevSum += root.key;
        boolean needremove = prefixSum.add(prevSum);
        //TODO 这种写法要学习！如果这次插入的数之前就有了，那么就不要remove了！
        if (prefixSum.contains(prevSum - target)) {
            return true;
        }
        if (root.left != null && helper(root.left, prefixSum, prevSum, target)) {
            return true;
        }
        if (root.right != null && helper(root.right, prefixSum, prevSum, target)) {
            return true;
        }
        if (needremove) {
            prefixSum.remove(prevSum);
        }
        return false;
    }

    public boolean exist2(TreeNode root, int target) {
        // Write your solution here.
        if (root == null) {
            return false;
        }
        return helper2(root, new ArrayList<TreeNode>(), target);
    }
    private boolean helper2(TreeNode root, List<TreeNode> path, int target) {
        path.add(root);
        int sum = 0;
        //TODO 时间复杂度n^2
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i).key;
            if (sum == target) {
                return true;
            }
        }
        if (root.left != null && helper2(root.left, path, target)) {
            return true;
        }
        if (root.right != null && helper2(root.right, path, target)) {
            return true;
        }
        //TODO 不能写成下面这样！！！否则会丢失一半结果。
        //TODO 上面那么写的话，如果true的话，会连续返回true，直到最顶层。这种写法要学习！
//        if (root.left != null) {
//            return helper(root.left, path, target);
//        }
//        if (root.right != null) {
//            return helper(root.right, path, target);
//        }
        //TODO 如果当前层左右两边都没找到的话，返回上一层前要Path中把当前层的Node删掉
        path.remove(path.size() - 1);
        return false;
    }
}
