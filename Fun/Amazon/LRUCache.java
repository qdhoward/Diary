package Fun.Amazon;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static class Node{
        int key;
        int value;
        Node next;
        Node pre;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        void update(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        remove(node);
        append(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            remove(node);
        } else if (map.size() < capacity) {
            node = new Node(key, value);
        } else {
            node = tail;
            remove(node);
            node.update(key, value);
        }
        append(node);
    }

    private void remove(Node node) {
        map.remove(node.key);
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = node.pre;
        }
        node.next = null;
        node.pre = null;
    }

    private void append(Node node) {
        map.put(node.key, node);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.pre = node;
            head = node;
        }
    }
}
