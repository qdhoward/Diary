package NewAutumn.topic.BestFS;

import util.Point;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class kthSmallestSumOfTwoSortedArray {
    private int[][] directions = new int[][] {
            new int[] {1, 0},
            new int[] {0, 1},
    };
    public int solution(int[] a, int[] b, int k) {
        int count = 0;
        PriorityQueue<Point> minHeap = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.cost == o2.cost) {
                    return 0;
                }
                return o1.cost < o2.cost ? -1 : 1;
            }
        });
        minHeap.offer(new Point(0, 0, 0));
        while (!minHeap.isEmpty()) {
            Point cur = minHeap.poll();
            count++;
            if (count == k) {
                return a[cur.x] + b[cur.y];
            }
            for (int[] direction : directions) {
                Point next = new Point(0, 0, 0);
                next.x = cur.x + direction[0];
                next.y = cur.y + direction[1];
                if (next.x >= a.length || next.y >= b.length) {
                    continue;
                }
                next.cost = a[next.x] + b[next.y];
                minHeap.offer(next);
            }
        }
        return -1;
    }
}
