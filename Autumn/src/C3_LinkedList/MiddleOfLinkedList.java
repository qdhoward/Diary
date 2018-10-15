package C3_LinkedList;

/**
 * Created by HaoYu on 2017/10/1.
 */
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        // write your solution here
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
