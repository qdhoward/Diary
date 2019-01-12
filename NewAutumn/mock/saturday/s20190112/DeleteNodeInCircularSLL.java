package NewAutumn.mock.saturday.s20190112;

import util.ListNode;

public class DeleteNodeInCircularSLL {
    public ListNode deleteNode(ListNode head) {
        if (head.next == head) {
            return head;
        }
        ListNode originalHead = head;
        head = head.next;
        ListNode current = head;
        ListNode prev = current;
        while (current != originalHead && current.next != originalHead) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = null;

            current = current.next;
            prev = current;
        }
        if (current == originalHead) {
            prev.next = head;
        } else {
            current.next = head;
        }
        return head;
    }
}
//"12345 1" "123456 1"