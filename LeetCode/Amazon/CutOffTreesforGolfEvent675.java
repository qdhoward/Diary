package LeetCode.Amazon;

import java.util.*;

public class CutOffTreesforGolfEvent675 {
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] directions = new int[][]{
            new int[]{-1, 0},
            new int[]{1, 0},
            new int[]{0, -1},
            new int[]{0, 1},
    };

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) {
            return -1;
        }
        Map<Integer, Point> position = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                int curHeight = forest.get(i).get(j);
                if (curHeight != 0) {
                    minHeap.offer(curHeight);
                    position.put(curHeight, new Point(i, j));
                }
            }
        }
        int curTree = minHeap.poll();
        int minStep = findMinStep(forest, new Point(0, 0), position.get(curTree));
        if (minStep == -1) {
            return -1;
        }
        while (!minHeap.isEmpty()) {
            Point curTreePos = position.get(curTree);
            forest.get(curTreePos.x).set(curTreePos.y, 1);
            int nextTree = minHeap.poll();
            Point nextTreePos = position.get(nextTree);
            int nextCost = findMinStep(forest, curTreePos, nextTreePos);
            if (nextCost == -1) {
                return -1;
            }
            minStep += nextCost;
            curTree = nextTree;
        }
        return minStep;
    }

    private int findMinStep(List<List<Integer>> forest, Point cur, Point next) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(cur);
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        visited[cur.x][cur.y] = true;
        int step = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                Point p = queue.poll();
                if (p.x == next.x && p.y == next.y) {
                    return step;
                }
                for (int[] direction : directions) {
                    int nextX = p.x + direction[0];
                    int nextY = p.y + direction[1];
                    if (nextX >= 0 && nextX < forest.size() && nextY >= 0 && nextY < forest.get(0).size()) {
                        if (forest.get(nextX).get(nextY) != 0 && !visited[nextX][nextY]) {
                            visited[nextX][nextY] = true;
                            queue.offer(new Point(nextX, nextY));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
