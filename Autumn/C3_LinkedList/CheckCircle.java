package Autumn.C3_LinkedList;

/**
 * Created by HaoYu on 2017/10/1.
 */
public class CheckCircle {
    public boolean hasCycle(ListNode head) {
        // write your solution here
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
