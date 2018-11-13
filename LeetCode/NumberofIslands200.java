package LeetCode;

public class NumberofIslands200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    res += 1;
                    traverseIsland(grid, visited, i, j);
                }
            }
        }
        return res;
    }

    private void traverseIsland(char[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        visited[i][j] = true;
        traverseIsland(grid, visited, i + 1, j);
        traverseIsland(grid, visited, i - 1, j);
        traverseIsland(grid, visited, i, j + 1);
        traverseIsland(grid, visited, i, j - 1);
    }
}
