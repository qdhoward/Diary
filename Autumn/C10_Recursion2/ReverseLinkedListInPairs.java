package C10_Recursion2;
import C3_LinkedList.ListNode;
/**
 * Created by HaoYu on 2017/10/20.
 */
public class ReverseLinkedListInPairs {
    public ListNode reverseInPairs(ListNode head) {
        // Write your solution here.
        if (head == null || head.next == null) {
            //TODO 不能写成return null!!!
            return head;
        }
        ListNode newHead = head.next;
        head.next = reverseInPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }
    public ListNode reverseInPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        dummy.next = head;
        while (cur.next != null && cur.next.next != null) {
            //TODO iterative 比如BACD因为我们在旋转完后CD后，还要把A和D连起来，所以必须用dummy,而且cur一直是要旋转的两个Node的前一个，相当于保持了prev！！！
            ListNode next = cur.next.next;
            cur.next.next = next.next;
            next.next = cur.next;
            cur.next = next;
            cur = cur.next.next;
        }
        return dummy.next;
    }
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
}
