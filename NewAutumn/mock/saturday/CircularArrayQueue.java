package NewAutumn.mock.saturday;

public class CircularArrayQueue {
    public int size;
    private int capacity;
    private int start;
    private int end;
    private int[] array;
    public CircularArrayQueue(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.array = new int[capacity];
        this.start = -1;
        this.end = -1;
    }
    public boolean add(int value) {
        if (size == capacity) {
            return false;
        }
        if (size == 0) {
            start = end = 0;
            array[0] = value;
        }
        end = (end + 1) % capacity;
        array[end] = value;
        size++;
        return true;
    }

    public boolean poll() {
        if (size == 0) {
            return false;
        }
        start = (start + 1) % capacity;
        size--;
        if (size == 0) {
            start = end = -1;
        }
        return true;
    }

    public Integer peekFirst () {
        if (size == 0) {
            return null;
        }
        return array[start];
    }

    public Integer peekLast () {
        if (size == 0) {
            return null;
        }
        return array[end];
    }
}
