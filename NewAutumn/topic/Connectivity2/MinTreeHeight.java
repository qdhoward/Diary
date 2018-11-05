package NewAutumn.topic.Connectivity2;

import util.KTreeNode;

import java.util.HashSet;
import java.util.Set;

public class MinTreeHeight {
    public int minTreeHeight(KTreeNode root) {
        Set<KTreeNode> visited = new HashSet<>();
        int[] res = new int[1];
        maxPathBetweenLeafNodes(root, visited, res);
        return res[1] / 2 + 1;
    }

    public int maxPathBetweenLeafNodes(KTreeNode root, Set<KTreeNode> visited, int[] res) {
        int height = 0;
        int count = 0;
        int maxHeight = 0;
        int secondMaxHeight = 0;
        for (int i = 0; i < root.neighbors.size(); i++) {
            KTreeNode node = root.neighbors.get(i);
            if (visited.add(node)) {
                int neiheight = maxPathBetweenLeafNodes(node, visited, res);
                height = Math.max(height, neiheight);
                if (neiheight > maxHeight) {
                    maxHeight = neiheight;
                } else if (neiheight > secondMaxHeight) {
                    secondMaxHeight = neiheight;
                }
            } else {
                count++;
            }
        }
        if (count == root.neighbors.size()) {
            return 1;
        }
        res[0] = Math.max(res[0], maxHeight + secondMaxHeight);
        return maxHeight + 1;
    }
}
