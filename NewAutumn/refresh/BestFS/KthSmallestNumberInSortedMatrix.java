package NewAutumn.refresh.BestFS;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestNumberInSortedMatrix {
    static class Node{
        int x;
        int y;
        int value;
        Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here.
        int x = matrix[0].length;
        int y = matrix.length;
        PriorityQueue<Node> minHeap = new PriorityQueue<>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        boolean[][] visited = new boolean[x][y];
        minHeap.offer(new Node(0, 0, matrix[0][0]));
        visited[0][0] = true;
        for (int i = 0; i < k; i++) {
            Node cur = minHeap.poll();
            if (cur.x + 1 < x && !visited[cur.x + 1][cur.y]) {
                minHeap.offer(new Node(cur.x + 1, y, matrix[cur.x + 1][cur.y]));
                visited[cur.x + 1][cur.y] = true;
            }
            if (cur.y + 1 < y && !visited[cur.x][cur.y + 1]) {
                minHeap.offer(new Node(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
                visited[cur.x][cur.y + 1] = true;
            }
        }

        return minHeap.peek().value;
    }
}
