package Fun.Amazon;

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer138 {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode newDummyHead = new RandomListNode(0);
        RandomListNode cur = newDummyHead;

        while (head != null) {
            Map<RandomListNode, RandomListNode> map = new HashMap<>();
            RandomListNode node = null;
            if (map.containsKey(head)) {
                node = map.get(head);
            } else {
                node = new RandomListNode(head.label);
                map.put(head, node);
            }
            cur.next = node;

            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    node = map.get(head.random);
                } else {
                    node = new RandomListNode(head.random.label);
                    map.put(head.random, node);
                }
                cur.next.random = node;
            }
            head = head.next;
            cur = cur.next;
        }
        return newDummyHead.next;
    }
}
