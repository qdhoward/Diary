package LeetCode.Facebook;

import util.ListNode;

public class ReorderList143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode midPrev = findMidNode(head);
        ListNode mid = midPrev.next;
        midPrev.next = null;
        ListNode secondHead = reverse(mid);
        ListNode dummy = new ListNode(0);
        ListNode curFirst = head;
        ListNode curSecond = secondHead;
        ListNode cur = dummy;
        while (curFirst != null && curSecond != null) {
            cur.next = curFirst;
            curFirst = curFirst.next;
            cur.next.next = curSecond;
            curSecond = curSecond.next;
            cur = cur.next.next;
        }
        // System.out.println(cur.val);
        // System.out.println(curFirst.val);
        // System.out.println(curSecond.val);
        cur.next = curFirst != null ? curFirst : curSecond;
    }
    private ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode root) {
        if (root.next == null) {
            return root;
        }
        ListNode head = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return head;
    }
}
