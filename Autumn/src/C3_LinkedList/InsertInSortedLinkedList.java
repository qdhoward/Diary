package C3_LinkedList;

/**
 * Created by HaoYu on 2017/10/1.
 */
public class InsertInSortedLinkedList {
    public ListNode insert(ListNode head, int value) {
        // write your solution here
        ListNode newnode = new ListNode(value);
        if(head == null || head.value >= value){
            newnode.next = head;
            return newnode;
        }
        ListNode cur = head;
        while(cur.next != null && value > cur.next.value){
            cur = cur.next;
        }
        newnode.next = cur.next;
        cur.next = newnode;
        return head;
    }
}
