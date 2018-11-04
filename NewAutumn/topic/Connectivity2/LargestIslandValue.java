package NewAutumn.topic.Connectivity2;

public class LargestIslandValue {
    public int largestIslandValue(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int res = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j] != 0) {
                    res = Math.max(traverseIsland(matrix, visited, i, j), res);
                }
            }
        }
        return res;
    }

    private int traverseIsland(int[][] matrix, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
            return 0;
        }
        if (matrix[x][y] == 0) {
            return 0;
        }
        if (visited[x][y]) {
            return 0;
        }

        visited[x][y] = true;
        int sum = matrix[x][y];
        sum += traverseIsland(matrix, visited, x + 1, y);
        sum += traverseIsland(matrix, visited, x - 1, y);
        sum += traverseIsland(matrix, visited, x, y + 1);
        sum += traverseIsland(matrix, visited, x, y - 1);
        return sum;
    }
}
