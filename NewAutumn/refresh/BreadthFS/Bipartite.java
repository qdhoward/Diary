package NewAutumn.refresh.BreadthFS;

import util.GraphNode;

import java.util.*;

public class Bipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        // write your solution here
        Map<GraphNode, Integer> group = new HashMap<>();
        for (GraphNode node: graph) {
            if (!bfs(group, node)) {
                return false;
            }
        }
        return true;
    }
    private boolean bfs(Map<GraphNode, Integer> group, GraphNode root) {
        if (group.containsKey(root)) {
            return true;
        }
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            int groupId = group.get(cur) == 0 ? 1 : 0;
            for (GraphNode node: cur.neighbors) {
                if (!group.containsKey(node)) {
                    queue.offer(node);
                    group.put(node, groupId);
                } else {
                    if (group.get(node) != groupId) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
