package Fun.Bloomberg;

import java.util.List;

public class MyHashMap {
    class ListNode {
        int key;
        int val;
        ListNode next;

        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }
    final ListNode[] nodes = new ListNode[10000];//TODO 和面试官讨论size
    /** Initialize your data structure here. */
    public MyHashMap() {
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = findIndex(key);
        if (nodes[index] == null) {
            nodes[index] = new ListNode(-1, - 1);
        }
        ListNode prev = find(nodes[index], key);
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.val = value;
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = findIndex(key);
        if (nodes[index] == null) {
            return -1;
        }
        ListNode node = find(nodes[index], key);
        return node.next == null ? -1 : node.next.val;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = findIndex(key);
        if (nodes[index] == null) {
            return;
        }
        ListNode prev = find(nodes[index], key);
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }

    private int findIndex(int key) {
        return Integer.hashCode(key) % nodes.length;
    }

    private ListNode find(ListNode bucket, int key) {
        ListNode node = bucket;
        ListNode prev = null;
        while (node != null && node.key != key) {//TODO 此处key如果是class的话，要用equal
            prev = node;
            node = node.next;
        }
        return prev;
    }
}
