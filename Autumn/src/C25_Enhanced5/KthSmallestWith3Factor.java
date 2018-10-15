package C25_Enhanced5;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by HaoYu on 2018/1/31.
 */
public class KthSmallestWith3Factor {
    public long kth(int k) {
        // Write your solution here
        PriorityQueue<Long> minheap = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        minheap.offer(3*5*7L);
        visited.add(3*5*7L);
        while(k > 1) {
            long current = minheap.poll();
            if (visited.add(current*3)) {
                minheap.offer(current*3);
            }
            if (visited.add(current*5)) {
                minheap.offer(current*5);
            }
            if (visited.add(current*7)) {
                minheap.offer(current*7);
            }
            k--;
            //TODO k--放到最后，因为x+1<y+1<z+1并不一定成立。
        }
        return minheap.peek();
    }
}
