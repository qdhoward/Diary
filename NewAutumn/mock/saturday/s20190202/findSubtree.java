package NewAutumn.mock.saturday.s20190202;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class findSubtree {
    public boolean contatinTheSubtree(TreeNode source, TreeNode target) {
        //Space O(n)
        if (target == null) {
            return true;
        }
        if (source == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(source);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.val == target.val) {
                if (isIdentical(cur, target)) {
                    return true;
                }
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return false;
    }

    public boolean contatinTheSubtree2(TreeNode source, TreeNode target) {
        //Space O(height)
        if (source == null && target == null) {
            return true;
        } else if (source == null || target == null) {
            return false;
        } else {
            return isIdentical(source, target) || contatinTheSubtree2(source.left, target) || contatinTheSubtree2(source.right, target);
        }

    }

    private boolean isIdentical(TreeNode source, TreeNode target) {
        if (source == null && target == null) {
            return true;
        } else if (source == null || target == null) {
            return false;
        } else if (source.val != target.val) {
            return false;
        }
        return isIdentical(source.left, target.left) && isIdentical(source.right, target.right);
    }
}
