package NewAutumn.topic.ConnectivityDFSAndBFS1;

import java.util.LinkedList;
import java.util.Queue;

public class GoIsDead {
    public boolean isDeadDfS(int[][] input, int x, int y) {
        //Time O(mn) Space O(log(mn)以4为底)
        boolean[][] visited = new boolean[input.length][input[0].length];
        return isDeadDfs(input, visited, x, y);
    }

    private boolean isDeadDfs(int[][] input, boolean[][] visited, int x, int y) {
        if (checkBoundary(x, y, input[0].length, input.length)) {
            return true;
        }
        if (visited[x][y]) {
            return true;
        }
        if (input[x][y] == 1) {
            return true;
        }
        if (input[x][y] == -1) {
            return false;
        }
        visited[x][y] = true;
        if (!isDeadDfs(input, visited, x + 1, y)) {
            return false;
        }
        if (!isDeadDfs(input, visited, x - 1, y)) {
            return false;
        }
        if (!isDeadDfs(input, visited, x, y + 1)) {
            return false;
        }
        if (!isDeadDfs(input, visited, x, y - 1)) {
            return false;
        }
        return true;
    }

    private boolean checkBoundary(int x, int y, int column, int row) {
        return x < 0 || x > column || y < 0 || y > row;
    }

    public boolean isDeadBfs(int[][] input, int x, int y) {
        //Time O(mn) Space O(m + n)
        return isDeadBfsHelper(input, x, y);
    }

    private boolean isDeadBfsHelper(int[][] input, int x, int y) {
        boolean[][] visited = new boolean[input.length][input[0].length];
        int[][] directions = new int[][] {
                new int[] {1, 0},
                new int[] {-1, 0},
                new int[] {0, 1},
                new int[] {0, -1},
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        while (queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] direction : directions) {
                int x_new = cur[0] + direction[0];
                int y_new = cur[1] + direction[1];
                if (checkBoundary(x_new, y_new, input[0].length, input.length) || visited[x_new][y_new] || input[x_new][y_new] == 1) {
                    continue;
                }
                if (input[x_new][y_new] == -1) {
                    return false;
                }
                if (input[x_new][y_new] == 0) {
                    visited[x_new][y_new] = true;
                    queue.offer(new int[] {x_new, y_new});
                }
            }
        }
        return true;
    }
}
