package NewAutumn.mock.saturday.s20190126;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfCrackers {
    private static int[][] DIRECTIONS = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }

    public int countCrackers(char[][] grid) {
        //Time O(n^2) Space O(n^2)
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'C' && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                    if (!extend(grid, visited, queue)) {
                        return -1;
                    }
                    count++;
                }
            }
        }
        return count;
    }

    private boolean extend(char[][] grid, boolean[][] visited, Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            boolean horizontal = false;
            boolean vertical = false;
            for (int i = 0; i < DIRECTIONS.length; i++) {
                int[] direction = DIRECTIONS[i];
                int x = cur[0] + direction[0];
                int y = cur[1] + direction[1];
                if (isOutOfBound(x, y, grid.length, grid[0].length) || grid[x][y] != 'C') continue;
                if (i < 2) {
                    horizontal = true;
                } else {
                    vertical = true;
                }
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                }
            }
            if (horizontal && vertical) {
                return false;
            }
        }
        return true;

    }

    public int countCrackers2(char[][] grid) {
        //Time O(n^2) Space O(1)
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '.') {
                    continue;
                }
                boolean up = i == 0 ? false : grid[i - 1][j] == 'C';
                boolean down = i == grid.length - 1 ? false : grid[i + 1][j] == 'C';

                boolean left = j == 0 ? false : grid[i][j - 1] == 'C';
                boolean right = j == grid[0].length - 1 ? false : grid[i][j + 1] == 'C';

                if (!up && !left) {
                    count++;
                }
                if ((up && left) || (down && right)) {
                    return -1;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(new NumberOfCrackers().countCrackers(new char[][] {
                {'.', '.', '.', '.', '.'},
                {'.', 'C', '.', '.', '.'},
                {'.', 'C', '.', '.', '.'},
                {'.', 'C', '.', '.', '.'},
                {'.', '.', 'C', 'C', 'C'},
        }));
    }
}
