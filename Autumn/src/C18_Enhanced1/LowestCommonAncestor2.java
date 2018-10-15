package C18_Enhanced1;


/**
 * Created by HaoYu on 2017/11/7.
 */
public class LowestCommonAncestor2 {
    public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
        // Write your solution here.
        int h1 = findHeight(one);
        int h2 = findHeight(two);
        if (h1 > h2) {
            return findAncestor(one, two, h1 - h2);
        } else {
            return findAncestor(two, one, h2 - h1);
        }
    }
    private TreeNodeP findAncestor(TreeNodeP deep, TreeNodeP shallow, int diff) {
        while (diff != 0) {
            deep = deep.parent;
            diff--;
        }
        while (deep != shallow) {
            deep = deep.parent;
            shallow = shallow.parent;
        }
        return deep;
    }
    private int findHeight(TreeNodeP root) {
        int height = 0;
        while (root != null) {
            height++;
            root = root.parent;
        }
        return height;
    }
}
