package NewAutumn.mock.saturday.s20190112;

import NewAutumn.mock.saturday.PopMaxStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Raindrop {
    private static int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private Map<Point, Point> map;
    public Raindrop() {
        this.map = new HashMap<>();
    }

    public class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    //Time amortized O(1) if input size >= n^2
    public List<Point> findDestOfRaindrops(List<int[]> raindrops, int[][] grid) {
        List<Point> res = new ArrayList<>();
        for (int[] r : raindrops) {
            Point raindrop = new Point(r[0], r[1]);
            Point currentResult = map.get(raindrop);
            if (currentResult == null) {
                currentResult = findDestOfOneRaindrop(r, grid);
                map.put(raindrop, currentResult);
            }
            res.add(currentResult);
        }
        return res;
    }

    private Point findDestOfOneRaindrop(int[] raindrop, int[][] grid) {
        int currentHeight = grid[raindrop[0]][raindrop[1]];
        boolean move = true;
        int[] cur = raindrop;
        while (move) {
            int[] prev = new int[] {cur[0], cur[1]};
            for (int[] direction : directions) {
                int nextX = raindrop[0] + direction[0];
                int nextY = raindrop[1] + direction[1];
                if (grid[nextX][nextY] < currentHeight) {
                    cur[0] = nextX;
                    cur[1] = nextY;
                    currentHeight = grid[nextX][nextY];
                }
            }
            if (cur[0] == prev[0] && cur[1] == prev[1]) {
                move = false;
            }
        }
        return new Point(cur[0], cur[1]);
    }
}
