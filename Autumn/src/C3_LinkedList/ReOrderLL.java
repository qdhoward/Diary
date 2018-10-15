package C3_LinkedList;

import java.util.List;

/**
 * Created by HaoYu on 2017/10/2.
 */
public class ReOrderLL {
    public ListNode reorder(ListNode head) {
        // Write your solution here.
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findmid(head);
        ListNode headsnd = reverse(mid.next);
        mid.next = null; // TODO 要断开，否则merge的时候有环
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (head != null && headsnd != null){
            ListNode next = head.next;
            cur.next = head;
            head = head.next; // TODO 先取next，再取cur.next.next
            cur.next.next = headsnd;
            headsnd = headsnd.next;
            cur = cur.next.next;
        }
        if(head == null){
            cur.next = headsnd;
        } else {
            cur.next = head;
        }
        return dummy.next;
    }
    private ListNode findmid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode newhead = reverse(next);
        next.next = head;
        head.next = null;
        return newhead;
    }
}
