package Autumn.C5_Heap_BFS1;

import Autumn.C3_LinkedList.QueueByTwoStacks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by HaoYu on 2017/10/4.
 */
public class Biparite {
    public boolean isBipartite(List<GraphNode> graph) {
        // write your solution here
        HashMap<GraphNode, Integer> visited = new HashMap<>();
        for (GraphNode node : graph) {
            if (!Bfs(node, visited)) {
                return false;
            }
        }
        return true;
    }
    private boolean Bfs(GraphNode node, HashMap<GraphNode, Integer> visited) {
        if (visited.containsKey(node)) {
            return true;
        }
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);
        visited.put(node, 0);
        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            int curGroup = visited.get(cur);
            int neiGroup = curGroup == 0 ? 1 : 0;
            for (GraphNode neighbor : cur.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    visited.put(neighbor, neiGroup);
                } else if (visited.get(neighbor) != neiGroup) {
                    return false;
                }
            }
        }
        return true;
    }
}
