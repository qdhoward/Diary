package util;

import java.util.ArrayList;
import java.util.List;

public class KTreeNode {
    public int value;
    public List<KTreeNode> neighbors;
    public KTreeNode(int value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
    }
}
