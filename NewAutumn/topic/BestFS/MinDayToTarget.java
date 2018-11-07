package NewAutumn.topic.BestFS;

import util.Point;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinDayToTarget {
    private int[][] directions = new int[][] {
            new int[] {1, 0},
            new int[] {-1, 0},
            new int[] {0, 1},
            new int[] {0, -1},
    };
    public int minDayToTarget(int[][] height) {
        PriorityQueue<Point> minHeap = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.cost == o2.cost) {
                    return 0;
                }
                return o1.cost < o2.cost ? -1 : 1;
            }
        });
        int result = 0;
        boolean[][] visited = new boolean[height.length][height[0].length];
        minHeap.offer(new Point(0, 0, 0));
        while (!minHeap.isEmpty()) {
            Point cur = minHeap.poll();
            if (visited[cur.x][cur.y]) {
                continue;
            }
            visited[cur.x][cur.y] = true;
            for (int[] direction : directions) {
                Point next = new Point(0, 0, 0);
                next.x = cur.x + direction[0];
                next.y = cur.y + direction[1];
                if (next.x < 0 || next.x >= height.length || next.y < 0 || next.y >= height[0].length) {
                    continue;
                }
                next.cost = Math.max(cur.cost, height[next.x][next.y]);
                minHeap.offer(next);
                if (next.x == height.length - 1 && next.y == height[0].length - 1) {
                    result = next.cost;
                    return result;
                }
            }
        }
        return result;
    }
}
