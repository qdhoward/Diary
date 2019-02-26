package Fun.Amazon;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC973 {
    public int[][] kClosest(int[][] points, int K) {
        if (points.length == 0 || K == 0) {
            return new int[0][0];
        }
        int[][] res = new int[K][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int distance1 = o1[0] * o1[0] + o1[1] * o1[1];
                int distance2 = o2[0] * o2[0] + o2[1] * o2[1];
                if (distance1 == distance2) {
                    return 0;
                }
                return distance1 < distance2 ? 1 : -1;
            }
        });
        for (int i = 0; i < points.length; i++) {
            int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            if (pq.size() >= K) {
                int distanceMax = pq.peek()[0] * pq.peek()[0] + pq.peek()[1] * pq.peek()[1];
                if (distance < distanceMax) {
                    pq.poll();
                    pq.offer(points[i]);
                }
            } else {
                pq.offer(points[i]);
            }
        }
        for (int i = 0; i < K; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

}
