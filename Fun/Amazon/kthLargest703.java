package Fun.Amazon;

import java.util.PriorityQueue;

public class kthLargest703 {
    private int k;
    private PriorityQueue<Integer> pq;
    public kthLargest703(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int i : nums) {
            add(i);//不能直接offer!!!!!
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        } else {
            if (pq.peek() < val) {
                pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek();
    }
}
