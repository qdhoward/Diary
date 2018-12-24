package LeetCode.Company.Facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class IsGraphBipartite785 {
    public boolean isBipartite(int[][] graph) {
        Map<Integer, Integer> group = new HashMap<>();
        for (int i = 0; i < graph.length; i++) {
            if (!group.containsKey(i)) {
                group.put(i, 0);
            } else {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (!queue.isEmpty()) {
                int curNode = queue.poll();
                int nextGroup = 1 - group.get(curNode);
                for (int node : graph[curNode]) {
                    if (group.containsKey(node)) {
                        if (group.get(node).equals(group.get(curNode))) {
                            return false;
                        }
                    } else {
                        group.put(node, nextGroup);
                        queue.offer(node);
                    }
                }
            }
        }
        return true;
    }
}
