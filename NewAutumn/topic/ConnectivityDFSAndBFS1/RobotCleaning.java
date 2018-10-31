package NewAutumn.topic.ConnectivityDFSAndBFS1;

import java.util.ArrayList;
import java.util.List;

public class RobotCleaning {
    public static int[][] directions = new int[][] {
            new int[] {1, 0},//down
            new int[] {-1, 0},//up
            new int[] {0, 1},//right
            new int[] {0, -1},//left
    };

    public List<String> navieSolution(int[][] matrix) {
        //Time O(4^(mn)) Space O(mn)
        List<String> res = new ArrayList<>();
        int remain = countRemainingPlace(matrix);
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        helper(matrix, 1, 1, 1, -1,true, remain, res, visited);
        return res;
    }

    private void helper(int[][] matrix, int x, int y, int previousPoint, int curDirection, boolean overRideflag, int remain, List<String> res, boolean[][] visited) {
        if (remain == 0) {//If there is no more places to be cleaned, the work id done.
            return;
        }
        if (outOfBoundary(x, y, matrix.length, matrix[0].length)) {//If current position is out of boundary, return.
            return;
        }
        if (matrix[x][y] == 1) {//If robot hits the obstacle, return.
            return;
        }
        if (visited[x][y]) {
            /*We can go back to visited position only under two situations:
            * 1. We hit the obstacle and we are surrounded by there obstacle
            * 2. we are surrounded by visited 0
            * */
            if (!(previousPoint == 1 || overRideflag)) {
                return;
            }
        }
        res.add("Move to " + String.format("[%d, %d]", x, y));
        if (matrix[x][y] == 0 && !visited[x][y]) {
            remain--;
            res.add("clean");
        }
        visited[x][y] = true;
        boolean overRideFlag = overRideFlag(matrix, x, y, visited);
        for (int i = 0; i < directions.length; i++) {
            // If we are surrounded by visited 0, we can't go to the opposite direction of the current direction.
            // To prevent infinite loop.
            if (overRideflag) {
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
            helper(matrix, x + directions[i][0], y + directions[i][1], matrix[x][y], i, overRideFlag, remain, res, visited);
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

    private boolean isSurrondedBy3Obstacle(int[][] matrix, int x, int y) {
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

    private boolean surroundedByVisitedZero(int[][] matrix, int x, int y, boolean[][] visited) {
        for (int[] direction : directions) {
            if (outOfBoundary(x + direction[0], y + direction[1], matrix.length, matrix[0].length)) {
                continue;
            }
            if (matrix[x + direction[0]][y + direction[1]] == 0 && !visited[x + direction[0]][y + direction[1]]) {
               return false;
            }
        }
        return true;
    }

    private boolean overRideFlag(int[][] matrix, int x, int y, boolean[][] visited) {
        if (isSurrondedBy3Obstacle(matrix, x, y) || surroundedByVisitedZero(matrix, x, y, visited)) {
            return true;
        }
        return false;
    }
}
