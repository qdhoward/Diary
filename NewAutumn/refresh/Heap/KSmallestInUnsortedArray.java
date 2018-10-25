package NewAutumn.refresh.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KSmallestInUnsortedArray {
    public int[] kSmallest(int[] array, int k) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 > o2 ? -1 : 1;
            }
        });
        for (int i = 0; i < k; i++) {
            maxHeap.offer()
        }
    }
}
