package LeetCode.Company.Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge934 {
    class Point{
        int x;
        int y;
        public Point(int x , int y) {
            this.x = x;
            this.y = y;
        }
    }
    final static int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] A) {
        int[][] array = A;
        int res = 0;
        int row = array.length;
        int col = array[0].length;
        boolean flag = false;
        boolean[][] visited = new boolean[array.length][array[0].length];
        Queue<Point> queue = new LinkedList();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++){
                if (flag){
                    break;
                }
                if (array[i][j] == 1) {
                    findFirstIslands(array, visited, i, j, queue);
                    flag = true;
                    break;
                }
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                for (int[] direction : directions) {
                    int nextX = cur.x + direction[0];
                    int nextY = cur.y + direction[1];
                    if (!outOfBoundary(nextX, nextY,row, col) &&!visited[nextX][nextY]) {
                        if (array[nextX][nextY] == 1){
                            return res;
                        }
                        queue.offer(new Point(nextX, nextY));
                        visited[nextX][nextY] = true;

                    }

                }
            }
            res++;
        }
        return -1;
    }


    private void findFirstIslands(int[][] array, boolean[][] visited, int i, int j, Queue<Point> queue) {
        if (outOfBoundary(i, j, array.length, array[0].length)) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (array[i][j] != 1) {
            return;
        }
        visited[i][j] = true;
        queue.offer(new Point(i, j));
        for (int[] direction : directions) {
            findFirstIslands(array, visited, i + direction[0], j + direction[1], queue);
        }
    }

    private boolean outOfBoundary(int i, int j, int row, int column) {
        if (i < 0 || i >= row || j < 0 || j >= column) {
            return true;
        }
        return false;
    }
}
