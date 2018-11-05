package NewAutumn.topic.Connectivity2;

import util.KTreeNode;

import java.util.HashSet;
import java.util.Set;

public class index {
    public static void main(String[] args) {
//        UnionFind test = new UnionFind();
//        System.out.println(test.naiveSolution(new String[] {"tars", "rats", "arts", "star"}));
//        System.out.println(test.solution2(new String[] {"tars", "rats", "arts", "star"}));
//        System.out.println(Arrays.toString(test.deleteExtraEdge(new int[][] {
//                new int[] {1, 2},
//                new int[] {1, 3},
//                new int[] {2, 3},
//        })));

        KTreeNode a = new KTreeNode(1);
        KTreeNode b = new KTreeNode(2);
        KTreeNode c = new KTreeNode(3);
        KTreeNode d = new KTreeNode(4);
        KTreeNode e = new KTreeNode(5);
        KTreeNode f = new KTreeNode(6);
        KTreeNode g = new KTreeNode(7);
        a.neighbors.add(d);
        b.neighbors.add(d);
        c.neighbors.add(d);
        d.neighbors.add(a);
        d.neighbors.add(b);
        d.neighbors.add(c);
        d.neighbors.add(e);
        e.neighbors.add(d);
        e.neighbors.add(f);
        e.neighbors.add(g);
        f.neighbors.add(e);
        f.neighbors.add(e);
        Set<KTreeNode> set = new HashSet<>();
        set.add(a);
        int[] res = new int[1];
        new MinTreeHeight().maxPathBetweenLeafNodes(a, set, res);
        System.out.println(res[0]);

//        NumOfIslandStream test2 = new NumOfIslandStream();
//        System.out.println(test2.appendCell(new int[] {0, 0}));
//        System.out.println(test2.appendCell(new int[] {0, 1}));
//        System.out.println(test2.appendCell(new int[] {1, 0}));
//        System.out.println(test2.appendCell(new int[] {1, 1}));
//        System.out.println(test2.appendCell(new int[] {2, 2}));
    }
}
