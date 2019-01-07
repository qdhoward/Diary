package NewAutumn.mock.saturday.s20190105;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintGoodSubtree {
    static class TreeNode {
        String key;
        String label;
        TreeNode left;
        TreeNode right;
        public TreeNode(String key) {
            this.key = key;
            this.label = "";
        }
    }

    public List<String> getAllGoodRoot(TreeNode root) {
        Set<TreeNode> goodRoots = new HashSet<>();
        buildGoodSet(root, goodRoots, root);
        List<String> res = new ArrayList<>();
        dfs(root, new StringBuilder(), goodRoots, res);
        return res;
    }

    private void dfs(TreeNode root, StringBuilder sb, Set<TreeNode> set, List<String> res) {
        if (root == null) {
            return;
        }
        sb.append(root.key);
        if (set.contains(root)) {
            res.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        dfs(root.left, sb, set, res);
        dfs(root.right, sb, set, res);
        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean buildGoodSet(TreeNode root, Set<TreeNode> set, TreeNode head) {
        if (root == null || root.label.equals("good")) {
            return true;
        }
        if (root.label.equals("bad")) {
            return false;
        }
        boolean left = buildGoodSet(root.left, set, head);
        boolean right = buildGoodSet(root.right, set, head);
        boolean res = left & right;
        if (res && root == head) {
            set.add(head);
        }
        if (!res) {
            //对非Leaf node节点才适用
            if (root.left != null && root.left.label.equals("") && left) {
                set.add(root.left);
            }
            if (root.right != null && root.right.label.equals("") && right) {
                set.add(root.right);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode("a");
        TreeNode b = new TreeNode("b");
        TreeNode c = new TreeNode("c");
        TreeNode e = new TreeNode("e");
        TreeNode f = new TreeNode("f");
        TreeNode g = new TreeNode("g");
        TreeNode h = new TreeNode("h");
        TreeNode i = new TreeNode("i");

        h.label = "good";
        i.label = "good";
        f.label = "bad";
        g.label = "good";

        a.left = b;
        a.right = c;
        b.left = e;
        b.right = f;
        e.left = h;
        e.right = i;
        c.right = g;
        System.out.println(new PrintGoodSubtree().getAllGoodRoot(a));
    }
}
