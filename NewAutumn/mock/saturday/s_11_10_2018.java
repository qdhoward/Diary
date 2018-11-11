package NewAutumn.mock.saturday;

import org.omg.PortableInterceptor.INACTIVE;
import util.Point;
import util.TreeNode;

import java.util.*;

public class s_11_10_2018 {
    //Q1
    public int lowestCostOfTrip (int[][] input, int start, int end, int n, int T) {
        class Vertex {
            private int city;
            private int transfer;
            private int cost;
            public Vertex (int city, int transfer, int cost) {
                this.city = city;
                this.transfer = transfer;
                this.cost = cost;
            }
        }
        PriorityQueue<Vertex> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        int[][] cost = new int[n][n];
        for (int i = 0; i < input.length; i++) {
            cost[input[i][0]][input[i][1]] = input[i][2];
        }
        minHeap.offer(new Vertex(start, 0, 0));
        Map<Integer, Vertex> visited = new HashMap<>();
        while (!minHeap.isEmpty()) {
            Vertex cur = minHeap.poll();
            if (cur.city == end) {
                return cur.cost;
            }
            if (cur.cost == T) {
                continue;
            }
            for (int i = 0; i < cost[cur.city].length; i++) {
                if (cur.cost + cost[cur.city][i] < visited.get(i).cost || cur.transfer + 1 < visited.get(i).transfer) {
                    minHeap.offer(new Vertex(i, cur.cost + cost[cur.city][i], visited.get(i).transfer + 1));
                }
            }
        }
        return 0;
    }

    //Q3
    public int longerstSubSequence(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int[] dp = new int[input.length];
        int max = 0;
        for (int i = 0; i < input.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (input[j] < input[i]) {
                    dp[i] = Math.max(dp[i],  dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int longerstSubSequence2(int[] input) {
        if (input == null || input.length == 0) {
            return 0;
        }
        int[] dp = new int[input.length];
        dp[0] = input[0];
        int result = 1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > dp[result - 1]) {
                dp[result] = input[i];
                result++;
            } else {
                int index = findSmallestLargerValue(input, 0, result, input[i]);
                dp[index] = input[i];
            }
        }
        return result;
    }

    //Q4
    private int findSmallestLargerValue(int[] array, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return array[left] >= target ? left : right;
    }

    //Q4
    public List<Integer> findAllNodes(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        if (k == 0) {
            res.add(target.key);
            return res;
        }
        Map<TreeNode, Integer> distanceToTarget = new HashMap<>();
        findPathToTarget(root, target.key, distanceToTarget);
        distanceToTarget.put(target, 0);
        findNodesByLevel(target, k, res);
        for (Map.Entry<TreeNode, Integer> entry : distanceToTarget.entrySet()) {
            if (entry.getValue() > k) {
                continue;
            }
            if (distanceToTarget.containsKey(entry.getKey().left)) {
                //If left child is contained in PathMap then we go to traverse the right subtree.
                findNodesByLevel(entry.getKey().right, entry.getValue() - 1, res);
            }
            if (distanceToTarget.containsKey(entry.getKey().right)) {
                findNodesByLevel(entry.getKey().left, entry.getValue() - 1, res);
            }
        }
        return res;

    }
    private void collectNodes(TreeNode root, int k, int distance, Map<TreeNode,
            Integer> distanceToTarget, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (distance == k) {//Why it can't returned
            res.add(root.key);
            return;
        }
        if (distanceToTarget.containsKey(root.left) || distance + 1 <= k) {
            collectNodes(root.left, k, distance + 1, distanceToTarget, res);
        }
        if (distanceToTarget.containsKey(root.right) || distance + 1 <= k) {
            collectNodes(root.left, k, distance + 1, distanceToTarget, res);
        }
    }

    private void findNodesByLevel(TreeNode root, int height, List<Integer> res) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curHeight = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (curHeight == height) {
                    res.add(cur.key);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            curHeight++;
        }
    }

    private int findPathToTarget(TreeNode root, int target, Map<TreeNode, Integer> distance) {
        if (root == null) {
            return -1;
        }
        if (root.key == target) {
            return 0;
        }
        int left = findPathToTarget(root.left, target, distance);
        int right = findPathToTarget(root.right, target, distance);
        int result = Math.max(left, right);
        if (result != -1) {
            result += 1;
            distance.put(root, result);
        }
        return result;
    }

}
