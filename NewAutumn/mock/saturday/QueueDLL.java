package NewAutumn.mock.saturday;

import util.DoubleListNode;

public class QueueDLL {
    private DoubleListNode head;
    private DoubleListNode tail;
    public int size;
    private int capacity;
    public QueueDLL(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new DoubleListNode(0);
        this.tail = new DoubleListNode(0);
        this.head.next = this.tail;
        this.tail.previous = this.head;
    }
    public boolean add(int value) {
        if (size == capacity) {
            return false;
        }
        DoubleListNode newNode = new DoubleListNode(value);
        DoubleListNode previousNode = tail.previous;
        previousNode.next = newNode;
        newNode.next = tail;
        tail.previous = newNode;
        newNode.previous = previousNode;
        size++;
        return true;
    }

    public boolean poll() {
        if (size == 0) {
            return false;
        }
        DoubleListNode result = head.next;
        head.next = result.next;
        result.next.previous = head;
        result.previous = null;
        result.next = null;
        size--;
        return true;
    }

    public Integer peekFirst () {
        return size == 0  ? null : head.next.key;
    }

    public Integer peekLast () {
        return size == 0 ? null : tail.previous.key;
    }
}
