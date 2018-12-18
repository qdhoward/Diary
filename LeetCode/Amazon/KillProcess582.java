package LeetCode.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KillProcess582 {
    //Time O(n) Space O(n)
    class Node {
        int key;
        List<Node> neighbors;
        public Node(int key) {
            this.key = key;
            this.neighbors = new ArrayList<>();
        }
    }
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Node> created = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            Node curPpid = created.get(ppid.get(i));
            Node curPid = created.get(pid.get(i));
            if (curPpid == null) {
                curPpid = new Node(ppid.get(i));
                created.put(ppid.get(i), curPpid);
            }
            if (curPid == null) {
                curPid = new Node(pid.get(i));
                created.put(pid.get(i), curPid);
            }
            curPpid.neighbors.add(curPid);
        }
        Node killNode = created.get(kill);
        List<Integer> res = new ArrayList<>();
        dfs(killNode, res);
        return res;
    }

    private void dfs (Node root, List<Integer> res) {
        res.add(root.key);
        for (Node nei : root.neighbors) {
            if (nei == null) {
                continue;
            }
            dfs(nei, res);
        }
    }
}
