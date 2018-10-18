package Autumn.C3_LinkedList;

/**
 * Created by HaoYu on 2017/10/2.
 */
public class MergeTwoLL {
    public ListNode merge(ListNode one, ListNode two) {
        // write your solution here
        if (one == null && two == null){
            return null;
        } else if (one == null){
            return two;
        } else if (two == null){
            return one;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null){
            if (one.value < two.value){
                cur.next = one;
                one = one.next;
            } else {
                cur.next = two;
                two = two.next;
            }
            cur = cur.next; //别忘了写这个！
        }
        if(one == null){
            cur.next = two;
        } else {
            cur.next = one;
        }
        return dummy.next;
    }
}
