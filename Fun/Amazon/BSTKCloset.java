package Fun.Amazon;

import util.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BSTKCloset {
    public List<Integer> closestKValues(TreeNode root, int target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(res, root, target, k);
        return res;
    }
    public void helper(LinkedList<Integer> res, TreeNode root, int target, int k){
        if(root == null){
            return;
        }
        helper(res, root.left, target, k);
        if(res.size() == k){
            if(Math.abs(root.val - target) < Math.abs(target - res.peekFirst())){
                res.removeFirst();
            }
            else{
                return;
            }
        }
        res.add(root.val);
        helper(res, root.right, target, k);
    }
}
