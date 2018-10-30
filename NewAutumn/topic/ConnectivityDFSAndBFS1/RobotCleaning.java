package NewAutumn.topic.ConnectivityDFSAndBFS1;

import java.util.ArrayList;
import java.util.List;

public class RobotCleaning {
    public static int[][] directions = new int[][] {
            new int[] {1, 0},
            new int[] {-1, 0},
            new int[] {0, 1},
            new int[] {0, -1},
    };

    public List<String> navieSolution(int[][] matrix) {
        List<String> res = new ArrayList<>();
        int remain = countRemainingPlace(matrix);
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        helper(matrix, 3, 3, 0, remain, res, visited);
        return res;
    }

    private void helper(int[][] matrix, int x, int y, int curDirection, int remain, List<String> res, boolean[][] visited) {
        if (remain == 0) {
            return;
        }
        if (outOfBoundary(x, y, matrix.length, matrix[0].length)) {
            return;
        }
        int nextX = x + directions[curDirection][0];
        int nextY = y + directions[curDirection][1];
        int next = matrix[nextX][nextY];
        if (visited[x][y]) {
            if (!isSoundedBy3Obstacle(matrix, x, y) && next != 1) {
                return;
            }
        }
        if (next == 0) {
            remain--;
        }
        visited[nextX][nextY] = true;
        res.add(new int[] {next, nextY}.toString());
        for (int i = 0; i < directions.length; i++) {
            helper(matrix, x + directions[curDirection][0], y + directions[curDirection][1], i, remain, res, visited);
        }
    }

    private int countRemainingPlace(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean outOfBoundary(int x, int y, int column, int row) {
        return x < 0 || x > column || y < 0 || y > row;
    }

    private boolean isSoundedBy3Obstacle (int[][] matrix, int x, int y) {
        int count = 0;
        for (int[] direction : directions) {
            if (matrix[x + direction[0]][y + direction[1]] == 1) {
                count++;
            }
        }
        if (count == 3) {
            return true;
        }
        return false;
    }
}
