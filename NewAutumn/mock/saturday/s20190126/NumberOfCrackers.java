package NewAutumn.mock.saturday.s20190126;

public class NumberOfCrackers {
    private static int[] getDirection(String directions) {
        int[] res = new int[0];
        switch (directions) {
            case "LEFT":
                res = new int[] {0, -1};
                break;
            case "RIGHT":
                res =  new int[] {0, 1};
                break;
            case "UP":
                res =  new int[] {-1, 0};
                break;
            case "DOWN":
                res =  new int[] {1, 0};
                break;
        }
        return res;
    }
    private boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }

    public int getNunbers(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'C' && !visited[i][j]) {

                    int[] right = getDirection("RIGHT");
                    int nextX = i + right[0];
                    int nextY = j + right[1];
                    int[] down = getDirection("DOWN");
                    int nextXDOwn = i + down[0];
                    int nextYDOwn = j + down[1];

                    if (grid[nextX][nextY] == 'C') {
                        if (extend(grid, visited, nextX, nextY, "RIGHT")) {
                            count++;
                        } else {
                            return -1;
                        }
                    } else if (grid[nextXDOwn][nextYDOwn] == 'C'){
                        if (extend(grid, visited, nextXDOwn, nextYDOwn, "DOWN")) {
                            count++;
                        } else {
                            return -1;
                        }
                    }
                }
            }
        }
        return count;
    }

    private boolean extend(char[][] grid, boolean[][] visited, int i, int j, String direction) {
        if (isOutOfBound(i, j, grid.length, grid[0].length) || grid[i][j] == '.') {
            return true;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        int[] dir = getDirection(direction);
        if (!extend(grid, visited, i +dir[0], i + dir[1], direction)) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println();
    }
}
