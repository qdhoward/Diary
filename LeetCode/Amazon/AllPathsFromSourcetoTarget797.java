package LeetCode.Amazon;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph.length == 0) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        dfs(0, graph, cur, res);
        return res;
    }

    private void dfs(int root, int[][] graph, List<Integer> cur, List<List<Integer>> res) {
        if (root == graph[graph.length - 1][0]) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int node : graph[root]) {
            cur.add(root);
            dfs(node, graph, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
