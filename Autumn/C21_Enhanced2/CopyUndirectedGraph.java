package Autumn.C21_Enhanced2;

import Autumn.C5_Heap_BFS1.GraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HaoYu on 2017/11/26.
 */
public class CopyUndirectedGraph {
    public List<GraphNode> copy(List<GraphNode> graph) {
        // Write your solution here.
        Map<GraphNode, GraphNode> created = new HashMap<>();
        List<GraphNode> res = new ArrayList<>();
        for (GraphNode g : graph) {
            res.add(helper(g, created));
        }
        return res;
    }
    private GraphNode helper (GraphNode input, Map<GraphNode, GraphNode> created) {
        if (input == null) {
            return null;
        }
        if (created.containsKey(input)) {
            return created.get(input);
        }
        GraphNode newNode = new GraphNode(input.key);
        created.put(input, newNode);
        for (GraphNode g : input.neighbors) {
            newNode.neighbors.add(helper(g, created));
        }
        return newNode;
    }
}
