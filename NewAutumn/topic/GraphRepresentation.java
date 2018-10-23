package NewAutumn.topic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphRepresentation {
    public int findShortestPath(int[][] maze, int[] start, int[] exit) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int costInPath = 1;
        int cost[][] = new int[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                List<int[]> neis = getNeighbors(cur, maze);
                for (int[] nei : neis) {
                    if (!visited[nei[0]][nei[1]]) {
                        visited[nei[0]][nei[1]] = true;
                        cost[nei[0]][nei[1]] += costInPath;
                        if (exit[0] == nei[0] && exit[1] == nei[1]) {
                            return cost[nei[0]][nei[1]];
                        }
                        queue.offer(new int[] {nei[0], nei[1]});
                    }
                }
            }
            costInPath++;
        }
        return Integer.MAX_VALUE;
    }

    private List<int[]> getNeighbors(int[] point, int[][] maze) {
        List<int[]> res = new ArrayList<>();
        if (maze[point[0] - 1][point[1]] != 1 && point[0] - 1 >= 0) {
            res.add(new int[] {point[0] - 1, point[1]});
        }
        if (maze[point[0]][point[1] - 1] != 1 && point[1] - 1 >= 0) {
            res.add(new int[] {point[0], point[1] - 1});
        }
        if (maze[point[0] + 1][point[1]] != 1 && point[0] + 1 <= maze[0].length - 1) {
            res.add(new int[] {point[0] + 1, point[1]});
        }
        if(maze[point[0]][point[1] + 1] != 1 && point[1] + 1 <= maze.length - 1) {
            res.add(new int[] {point[0], point[1] + 1});
        }
        return res;
    }

    class vertex {
        public int x;
        public int y;
        public int num;
        public vertex (int x, int y, int numOfObstacle) {
            this.x = x;
            this.y = y;
            this.num = numOfObstacle;
        }
    }

    public int findShortestPathWithKObstacles(int[][] maze, vertex start, vertex exit, int k) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int costInPath = 1;
        int cost[][] = new int[maze.length][maze[0].length];
        Queue<vertex> queue = new LinkedList<>();
        visited[start.x][start.y] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                vertex cur = queue.poll();
                List<vertex> neis = getNeighborsWithObstacle(cur, maze);
                for (vertex nei : neis) {
                    if (!visited[nei.x][nei.y]) {
                        visited[nei.x][nei.y] = true;
                        cost[nei.x][nei.y] += costInPath;
                        if (exit.x == nei.x && exit.y == nei.y && nei.num <= k) {
                            return cost[nei.x][nei.y];
                        }
                        queue.offer(nei);
                    }
                }
            }
            costInPath++;
        }
        return Integer.MAX_VALUE;
    }

    private List<vertex> getNeighborsWithObstacle(vertex point, int[][] maze) {
        List<vertex> res = new ArrayList<>();
        if (point.x - 1 >= 0) {
            int num = maze[point.x - 1][point.y] == 1 ? point.num + 1 : point.num;
            res.add(new vertex(point.x - 1, point.y, num));
        }
        if (point.y - 1 >= 0) {
            int num = maze[point.x][point.y - 1] == 1 ? point.num + 1 : point.num;
            res.add(new vertex(point.x, point.y - 1, num));
        }
        if (point.x + 1 <= maze[0].length - 1) {
            int num = maze[point.x + 1][point.y] == 1 ? point.num + 1 : point.num;
            res.add(new vertex(point.x + 1, point.y, num));
        }
        if(point.y + 1 <= maze.length - 1) {
            int num = maze[point.x][point.y + 1] == 1 ? point.num + 1 : point.num;
            res.add(new vertex(point.x, point.y + 1, num));
        }
        return res;
    }

}
