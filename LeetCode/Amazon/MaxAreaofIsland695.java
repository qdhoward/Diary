package LeetCode.Amazon;

public class MaxAreaofIsland695 {
    private static int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int[] cur = new int[1];
                    traverseIsland(i, j, grid, visited, cur);
                    max = Math.max(max, cur[0]);
                }
            }
        }
        return max;
    }

    private void traverseIsland(int i, int j, int[][] grid, boolean[][] visited, int[] res) {
        if (outOfBoundary(i, j, grid.length, grid[0].length)) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        res[0]++;
        for (int[] direction : directions) {
            traverseIsland(i + direction[0], j + direction[1], grid, visited, res);
        }
    }

    private boolean outOfBoundary(int i, int j, int row, int col) {
        return i < 0 || i >= row || j < 0 || j >= col;
    }
}
