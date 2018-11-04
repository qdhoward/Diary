package NewAutumn.topic.Connectivity2;

public class NumberOfIsland {
    public int numberOfIsland(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int res = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    res++;
                    traverseIsland(matrix, visited, i, j);
                }
            }
        }
        return res;
    }

    private void traverseIsland(int[][] matrix, boolean[][] visited, int x, int y) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
            return;
        }
        if (matrix[x][y] != 1) {
            return;
        }
        if (visited[x][y]) {
            return;
        }

        visited[x][y] = true;
        traverseIsland(matrix, visited, x + 1, y);
        traverseIsland(matrix, visited, x - 1, y);
        traverseIsland(matrix, visited, x, y + 1);
        traverseIsland(matrix, visited, x, y - 1);
    }
}
