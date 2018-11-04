package NewAutumn.topic.Connectivity2;

public class NumberOfLake {
    public int numberOfLake(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int res = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j] == 0) {
                    if (!canReachBoundary(matrix, visited, i, j)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private boolean canReachBoundary(int[][] matrix, boolean[][] visited, int x, int y) {
        //判断点x，y是否能走到边界，如果从0点能走到边界，自然不是湖
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
            return true;
        }
        if (matrix[x][y] != 0) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }

        visited[x][y] = true;
        boolean result = false;
        //要确保所有的点都走一遍，所以不能直接return
        result |= canReachBoundary(matrix, visited, x + 1, y);
        result |= canReachBoundary(matrix, visited, x - 1, y);
        result |= canReachBoundary(matrix, visited, x, y + 1);
        result |= canReachBoundary(matrix, visited, x, y - 1);
        return result;
    }
}
