package NewAutumn.mock.saturday.s20190112;

import util.DoubleListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupNodesInDLL {
    public int groupNodes(DoubleListNode head, List<DoubleListNode> nodes) {
        Set<DoubleListNode> set = new HashSet<>(nodes);
        DoubleListNode current = head;
        int res = 0;
        while (current != null) {
            if (set.contains(current)) {
                res++;
                while (current != null && set.contains(current)) {
                    current = current.next;
                }
            } else {
                current = current.next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DoubleListNode head = new DoubleListNode(1);
        DoubleListNode a = new DoubleListNode(2);
        DoubleListNode b = new DoubleListNode(3);
        DoubleListNode c = new DoubleListNode(4);
        DoubleListNode d = new DoubleListNode(5);
        DoubleListNode e = new DoubleListNode(6);
        DoubleListNode f = new DoubleListNode(7);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = null;
        List<DoubleListNode> nodes = new ArrayList<>();
        nodes.add(a);
        nodes.add(c);
        nodes.add(d);
        nodes.add(f);
        System.out.println(new GroupNodesInDLL().groupNodes(head, nodes));
    }
}
