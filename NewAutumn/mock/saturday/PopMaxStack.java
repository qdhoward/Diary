package NewAutumn.mock.saturday;

import java.util.*;

public class PopMaxStack {
    private TreeMap<Integer, List<Node>> treeMap;
    private DoubleLinkedList list;

    class Node {
        Node pre;
        Node next;
        int value;
        Node(int value) {
            this.value = value;
        }
    }

    class DoubleLinkedList {
        Node tail;
        Node dummy;
        int size;

        DoubleLinkedList() {
            this.dummy = new Node(0);
            this.tail = dummy;
            size = 0;
        }

        public Node add(int x) {
            Node node = new Node(x);
            tail.next = node;
            node.pre = tail;
            tail = tail.next;
            size++;
            return node;
        }

        public void unlink(Node node) {
            if (node.next == null) {
                delete();
                return;
            }
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        public int delete() {
            int res = tail.value;
            tail = tail.pre;
            tail.next = null;
            size--;
            return res;
        }

        public int peekLast() {
            return tail.value;
        }


    }

    /** initialize your data structure here. */
    public PopMaxStack() {
        treeMap = new TreeMap<>();
        list = new DoubleLinkedList();
    }

    public void push(int x) {

        Node newNode = list.add(x);
        List<Node> n  = treeMap.get(x);
        if (n == null) {
            n = new ArrayList<>();
        }
        n.add(newNode);
        treeMap.put(x, n);
    }

    public int pop() {
        List<Node> l = treeMap.get(list.peekLast());
        l.remove(l.size() - 1);
        if (l.isEmpty()) {
            treeMap.remove(list.peekLast());
        }
        return list.delete();
    }

    public int top() {
        return list.peekLast();
    }

    public int peekMax() {
        return treeMap.lastKey();
    }

    public int popMax() {
        Integer max = peekMax();
        List<Node> listNode = treeMap.get(max);
        Node n = listNode.remove(listNode.size() - 1);
        if (listNode.isEmpty()) treeMap.remove(max);
        list.unlink(n);
        return max;
    }
}
