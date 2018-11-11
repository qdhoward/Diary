package util;

public class DoubleListNode {
    public DoubleListNode previous;
    public DoubleListNode next;
    public int key;
    public DoubleListNode(int key) {
        this.key = key;
        this.previous = null;
        this.next = null;
    }
}
