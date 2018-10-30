package NewAutumn.topic.ConnectivityDFSAndBFS1;

import java.util.*;

public class ContinentalDivider {
    public List<int[]> solution(int[][] input) {
        Set<int[]> left = new HashSet<>();
        Set<int[]> right = new HashSet<>();
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            bfs(input, left, 0, i);
            bfs(input, right, input[0].length - 1, i);
        }
        for (int[] leftReachable : left) {
            if (right.contains(leftReachable)) {
                res.add(leftReachable);
            }
        }
        return res;
    }

    private void bfs(int[][] input, Set<int[]> res, int x, int y) {
        int[][] directions = new int[][] {
                new int[] {1, 0},
                new int[] {-1, 0},
                new int[] {0, 1},
                new int[] {0, -1},
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] direction : directions) {
                int x_new = cur[0] + direction[0];
                int y_new = cur[1] + direction[1];
                if(input[x_new][y_new] >= input[x][y]) {
                    int[] next = new int[] {x_new, y_new};
                    res.add(next);
                    queue.offer(next);
                }
            }
        }
    }
}
