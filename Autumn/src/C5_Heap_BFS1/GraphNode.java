package C5_Heap_BFS1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HaoYu on 2017/10/4.
 */
public class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<GraphNode>();
    }
}
