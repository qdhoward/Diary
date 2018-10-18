package Autumn.C3_LinkedList;

/**
 * Created by HaoYu on 2017/10/2.
 */
public class PartitionLinkedList {
    public ListNode partition(ListNode head, int target) {
        // write your solution here
        if (head == null || head.next == null){
            return head;
        }
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode curSmall = small;
        ListNode curLarge = large;
        while (head != null){
            if (head.value < target) {
                curSmall.next = head;
                curSmall = curSmall.next;
            } else {
                curLarge.next = head;
                curLarge = curLarge.next;
            }
            head = head.next;
        }
        curSmall.next = large.next;
        curLarge.next = null;
        return small.next;
    }
}
