package NewAutumn.topic.ConnectivityDFSAndBFS1;

import java.util.ArrayList;
import java.util.List;

public class RobotCleaning {
    public static int[][] directions = new int[][] {
            new int[] {1, 0},//下
            new int[] {-1, 0},//上
            new int[] {0, 1},//右
            new int[] {0, -1},//左
    };

    public List<String> navieSolution(int[][] matrix) {
        List<String> res = new ArrayList<>();
        int remain = countRemainingPlace(matrix);
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        helper(matrix, 1, 1, 1, -1,true, remain, res, visited);
        return res;
    }

    private void helper(int[][] matrix, int x, int y, int previousPoint, int curDirection, boolean flag, int remain, List<String> res, boolean[][] visited) {
        if (remain == 0) {
            return;
        }
        if (outOfBoundary(x, y, matrix.length, matrix[0].length)) {
            return;
        }
        if (matrix[x][y] == 1) {
            return;
        }
        if (visited[x][y]) {
            if (!(previousPoint == 1 || flag)) {
                return;
            }
        }
        res.add("Move to " + String.format("[%d, %d]", x, y));
        if (matrix[x][y] == 0 && !visited[x][y]) {
            remain--;
            res.add("clean");
        }
        visited[x][y] = true;
        boolean isSurrondedBy3Obstacle = isSurrondedBy3Obstacle(matrix, x, y, visited);
        int surroundedVisitedZero = surroundedVisitedZero(matrix, x, y, visited);
        for (int i = 0; i < directions.length; i++) {
            if (surroundedVisitedZero > 1) {
                if (curDirection == 0 || curDirection == 2) {
                    if (i == curDirection + 1) {
                        continue;
                    }
                } else {
                    if (i == curDirection - 1) {
                        continue;
                    }
                }
            }
            helper(matrix, x + directions[i][0], y + directions[i][1], matrix[x][y], i, isSurrondedBy3Obstacle, remain, res, visited);
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
        return x < 0 || x >= row || y < 0 || y >= column;
    }

    private boolean isSurrondedBy3Obstacle(int[][] matrix, int x, int y, boolean[][] visited) {
        int countObstacle = 0;
        for (int[] direction : directions) {
            if (outOfBoundary(x + direction[0], y + direction[1], matrix.length, matrix[0].length)) {
                continue;
            }
            if (matrix[x + direction[0]][y + direction[1]] == 1) {
                countObstacle++;
            }
        }
        if (countObstacle == 3) {
            return true;
        }
        return false;
    }

    private int surroundedVisitedZero(int[][] matrix, int x, int y, boolean[][] visited) {
        int count = 0;
        for (int[] direction : directions) {
            if (outOfBoundary(x + direction[0], y + direction[1], matrix.length, matrix[0].length)) {
                continue;
            }
            if (matrix[x + direction[0]][y + direction[1]] == 0 && visited[x + direction[0]][y + direction[1]]) {
                count++;
            }
        }
        return count;
    }
}
