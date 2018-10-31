package NewAutumn.topic.ConnectivityDFSAndBFS1;

import java.util.*;

public class ContinentalDivider {
    private static int[][] directions = new int[][] {
            new int[] {1, 0},
            new int[] {-1, 0},
            new int[] {0, 1},
            new int[] {0, -1},
    };
    public List<String> solution(int[][] input) {
        Set<String> left = new HashSet<>();
        Set<String> right = new HashSet<>();
        Queue<int[]> leftQueue = new LinkedList<>();
        Queue<int[]> rightQueue = new LinkedList<>();
        boolean[][] leftVisited = new boolean[input.length][input[0].length];
        boolean[][] rightVisited = new boolean[input.length][input[0].length];
        List<String> res = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            leftQueue.offer(new int[] {i, 0});
            rightQueue.offer(new int[] {i, input[0].length - 1});
            leftVisited[i][0] = true;
            rightVisited[i][input[0].length - 1] = true;
        }
        bfs(input, left, leftQueue, leftVisited);
        bfs(input, right, rightQueue, rightVisited);
        for (String leftReachable : left) {
            if (right.contains(leftReachable)) {
                res.add(leftReachable);
            }
        }
        return res;
    }

    private void bfs(int[][] input, Set<String> res, Queue<int[]> queue, boolean[][] visited) {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] direction : directions) {
                int x_new = cur[0] + direction[0];
                int y_new = cur[1] + direction[1];
                if(!outOfBoundary(x_new, y_new, input.length, input[0].length) && !visited[x_new][y_new] && input[x_new][y_new] >= input[cur[0]][cur[1]]) {
                    int[] next = new int[]{x_new, y_new};
                    visited[x_new][y_new] = true;
                    res.add(Arrays.toString(next));
                    queue.offer(next);
                }
            }
        }
    }

    private boolean outOfBoundary(int x, int y, int column, int row) {
        return x < 0 || x >= row || y < 0 || y >= column;
    }
}
