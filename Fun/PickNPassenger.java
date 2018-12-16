package Fun;

import java.util.*;

public class PickNPassenger {
    // Assuming number of riders is n. Number of riders who will be picked up is k.
    // Time(n!) Space(nk)
    public static int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};

    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Rider {
        int x;
        int y;
        int cost;
        Set<Rider> path;
        Rider (int x, int y) {
            this.x = x;
            this.y = y;
            this.path = new LinkedHashSet<>();
            this.cost = 0;
        }
        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof Rider)) {
                return false;
            }
            Rider another = (Rider) object;
            return this.x == another.x && this.y == another.y;
        }

        @Override
        public int hashCode() {
            return x * 31 + y;
        }
    }

    public List<List<Integer>> pickUpRider(char[][] matrix, int n) {
        PriorityQueue<Rider> pq = new PriorityQueue<>((Rider p1, Rider p2) -> {
            if (p1.cost == p2.cost) {
                return 0;
            } else {
                return p1.cost < p2.cost ? -1 : 1;
            }
        });
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        queue.offer(new Point(0,0));
        visited[0][0] = true;
        int level = 0;
        //At first, we put every rider in the pq and each cost equals his distance to driver.
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            level++;
            for (int i = 0; i < directions.length; i++) {
                int row = cur.x + directions[i][0];
                int col = cur.y + directions[i][1];
                if (!isOutOfBound(row, col, matrix.length, matrix[0].length)
                        && !visited[row][col] && matrix[row][col] != 'B') {
                    queue.offer(new Point(row, col));
                    visited[row][col] = true;
                    if (matrix[row][col] == 'R') {
                        Rider nextRider = new Rider(row, col);
                        nextRider.cost = level;
                        nextRider.path.add(nextRider);
                        pq.offer(nextRider);
                    }
                }
            }
        }
        // If number of riders is less then number of riders who will be picked up, then there is no way to get the best path.
        if (pq.size() < n) {
            return new ArrayList<>();
        }
        Map<Rider, Map<Rider, Integer>> ridersDistMap = getAllRiderDistance(matrix);
        Set<Rider> path = new LinkedHashSet<>();
        int cost = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Rider cur = pq.poll();
            System.out.println(cur.path.size());
            if (cur.path.size() == n + 1) {
                return constructResult(path);
            }
            if (cur.path.size() == n && cur.cost < cost) {
                cost = cur.cost;
                path = new LinkedHashSet<>(cur.path);
            }
            for (Map.Entry<Rider, Integer> entry : ridersDistMap.get(cur).entrySet()) {
                Rider nextRider = new Rider(entry.getKey().x, entry.getKey().y);
                if (!cur.path.contains(nextRider)) {
                    nextRider.path = new LinkedHashSet<>(cur.path);
                    nextRider.path.add(nextRider);
                    nextRider.cost = cur.cost + entry.getValue();
                    pq.offer(nextRider);
                }
            }
        }
        return constructResult(path);
    }

    //Preprocess, run bfs on every driver.
    private Map<Rider, Map<Rider, Integer>> getAllRiderDistance(char[][] matrix){
        Map<Rider, Map<Rider, Integer>> riderDistMap = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'R') {
                    Rider rider = new Rider(i, j);
                    if (!riderDistMap.containsKey(rider)) {
                        riderDistMap.put(rider, new HashMap<>());
                        buildDistanceMap(rider, matrix, riderDistMap);
                    }
                }
            }
        }
        return riderDistMap;
    }

    //Preprocess, run bfs on given driver.
    private void buildDistanceMap(Rider rider, char[][] matrix, Map<Rider, Map<Rider, Integer>> riderDistsMap) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        queue.offer(new Point(rider.x, rider.y));
        visited[rider.x][rider.y] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            level++;
            for (int i = 0; i < directions.length; i++) {
                int row = cur.x + directions[i][0];
                int col = cur.y + directions[i][1];
                if (!isOutOfBound(row, col, matrix.length, matrix[0].length)
                        && !visited[row][col] && matrix[row][col] != 'B') {
                    queue.offer(new Point(row, col));
                    visited[row][col] = true;
                    if (matrix[row][col] == 'R') {
                        Rider nextRider = new Rider(row, col);
                        riderDistsMap.get(rider).put(nextRider, level);
                    }
                }
            }
        }
    }

    private boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }

    //Convert the path to List<List<Integer>>
    private List<List<Integer>> constructResult(Set<Rider> path) {
        List<List<Integer>> res = new ArrayList<>();
        for (Rider r : path) {
            res.add(Arrays.asList(r.x, r.y));
        }
        return res;
    }

    public static void main(String[] args) {
        PickNPassenger test = new PickNPassenger();
        System.out.println(test.pickUpRider(new char[][] {
                {'D', 'B', '-', '-', '-'},
                {'R', 'R', '-', 'R', 'R'},
                {'-', 'B', 'B', 'B', '-'},
                {'R', 'R', 'R', 'R', 'R'},
        }, 5));
    }
}
