package C21_Enhanced2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HaoYu on 2017/11/26.
 */
public class CopyLinkedListWithRandomPointer {
    public RandomListNode copy(RandomListNode head) {
        // Write your solution here.
        if (head == null) {
            return null;
        }
        RandomListNode newHead = new RandomListNode(head.value);
        Map<RandomListNode, RandomListNode> created = new HashMap<>();
        created.put(head, newHead);
        RandomListNode cur = newHead;
        while (head != null) {
            if (head.next != null) {
                if (!created.containsKey(head.next)) {
                    created.put(head.next, new RandomListNode(head.next.value));
                }
                cur.next = created.get(head.next);
            }
            if (head.random != null) {
                if (!created.containsKey(head.random)) {
                    created.put(head.random, new RandomListNode(head.random.value));
                }
                cur.random = created.get(head.random);
            }
            cur = cur.next;
            head = head.next;
        }
        return newHead;
    }
}
