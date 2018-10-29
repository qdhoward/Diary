package NewAutumn.topic.GraphRepresentation;

import java.util.*;

public class GraphRepresentation {
    //Problem1
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

    public List<String> crossRiver() {
        Map<String, Boolean> positionA = new HashMap<>();
        positionA.put("wolf", true);
        positionA.put("sheep", true);
        positionA.put("grass", true);
        positionA.put("farmer", true);
        List<String> res = new ArrayList<>();
        while (positionA.size() != 2) {
            if (positionA.containsKey("wolf")) {
                if ((!positionA.containsKey("sheep") && !positionA.containsKey("grass")) || positionA.containsKey("sheep")) {
                    positionA.remove("wolf");
                    res.add("wolf");
                }
            }
            if (positionA.containsKey("sheep")) {
                if (positionA.containsKey("wolf") && positionA.containsKey("grass")) {
                    positionA.remove("sheep");
                    res.add("sheep");
                }
            }
            if (positionA.containsKey("grass")) {
                if ((!positionA.containsKey("sheep") && !positionA.containsKey("wolf")) || positionA.containsKey("sheep")) {
                    positionA.remove("grass");
                    res.add("grass");
                }
            }
        }
        return res;
    }

    public int turnOnLight() {
        int[][] matrix = new int[4][4];
        int[] cost = new int[] {0};
        turnOnLightHelper(0, matrix, cost);
        return cost[0];

    }

    private void turnOnLightHelper(int index, int[][] matrix, int[] cost) {
        if (checkIsAllLighted(matrix)) {
            return;
        }
        int x = index % 4;
        int y = index / 4;
        toggleNeighbor(matrix, x, y);
        cost[0] = cost[0] + 1;
        turnOnLightHelper(index + 1, matrix, cost);
        toggleNeighbor(matrix, x, y);
        cost[0] = cost[0] - 1;
        turnOnLightHelper(index + 1, matrix, cost);
    }

    private boolean checkIsAllLighted(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private void toggleNeighbor(int[][] matrix, int x, int y) {
        if (x - 1 >= 0) {
            matrix[x - 1][y] = 1 - matrix[x - 1][y];
        }
        if (y - 1 >= 0) {
            matrix[x][y - 1] = 1 - matrix[x][y - 1];
        }
        if (x + 1 < matrix[0].length) {
            matrix[x + 1][y] = 1 - matrix[x + 1][y];
        }
        if (y + 1 < matrix.length) {
            matrix[x][y + 1] = 1 - matrix[x][y + 1];
        }
    }

    class Radar{
        public double x;
        public double y;
        public double radius;
        public List<Radar> neighbors;
        public Radar(double x, double y, double radius) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.neighbors = new ArrayList<>();
        }
    }

    public boolean canvehiclePass(Radar[] radars) {
        buildGraph(radars);
        Set<Radar> visited = new HashSet<>();
        for (int i = 0; i < radars.length; i++) {

        }
        return false;
    }


    private boolean areCirclesOverlapped(Radar a, Radar b) {
        double distance = Math.pow(Math.abs(a.x - b.x), 2) + Math.pow(Math.abs(a.y - b.y), 2);
        return distance < Math.pow(a.radius + b.radius, 2);
    }

    private void buildGraph(Radar[] radars) {
        for (int i = 0; i < radars.length; i++) {
            for (int j = i + 1; j < radars.length; j++) {
                if (areCirclesOverlapped(radars[i], radars[j])) {
                    radars[i].neighbors.add(radars[j]);
                }
            }
        }
    }

    public Map<String, Integer> currecnyExchange(Map<String, Float> rate) {
        //Assuming the input entry is formatted as <A/B, 2.0>
        return new HashMap<String, Integer>();
    }
}
