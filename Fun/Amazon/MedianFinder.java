package Fun.Amazon;


import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    public MedianFinder() {
        this.small = new PriorityQueue<>(Collections.reverseOrder());
        this.large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
        } else {
            large.offer(num);
        }
        if (small.size() - large.size() >= 2) {
            large.offer(small.poll());
        } else if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        int size = small.size() + large.size();
        if (size == 0) {
            return 0;
        } else if (size % 2 != 0) {
            return (double) small.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}
