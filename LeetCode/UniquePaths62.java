package LeetCode;

import java.util.Map;

public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        int[][] visited = new int[m + n - 1][m];
        return combination(m + n - 2, m - 1, visited);
    }
    private int combination(int x, int y, int[][] visited) {
        if (y == 0) {
            return 1;
        }
        if (x <= 0 || y < 0) {
            return 0;
        }
        if (x < y) {
            return 0;
        }
        if (x == y) {
            visited[x][y] = 1;
            return 1;
        }
        if (visited[x][y] != 0) {
            return visited[x][y];
        }
        visited[x][y] = combination(x - 1, y, visited) + combination(x - 1, y - 1, visited);
        return visited[x][y];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths62().combination(25 ,9, new int[32][24]));
    }
}
