package C21_Enhanced2;

import C3_LinkedList.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by HaoYu on 2017/11/26.
 */
public class MergeKSortedLists {
    public ListNode merge(List<ListNode> listOfLists) {
        // Write your solution here/.
        if (listOfLists == null || listOfLists.size() == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(13, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        for (int i = 0; i < listOfLists.size(); i++) {
            pq.offer(listOfLists.get(i));
        }
        while (!pq.isEmpty()) {
            ListNode next = pq.poll();
            cur.next = next;
            cur = cur.next;
            if (next.next != null) {
                pq.offer(next.next);
            }
        }
        return dummy.next;
    }
}
