package Autumn.C3_LinkedList;

/**
 * Created by HaoYu on 2017/10/1.
 */
public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        // write your solution here
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode newhead = reverse(next);
        next.next = head;
        head.next = null;
        return newhead;
    }

    public ListNode reverse2(ListNode head) {
        // write your solution here
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
