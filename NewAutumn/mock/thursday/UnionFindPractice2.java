package NewAutumn.mock.thursday;

import java.util.*;

public class UnionFindPractice2 {
    /*
    Q1 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
    Input: [100, 4, 200, 1, 3, 2]
    Output: 4
    */

    public int findLongest(int[] input) {
        Arrays.sort(input);
        int result = 0;
        int curResult = 1;
        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[i - 1] + 1) {
                curResult++;
            } else {
                curResult = 1;
            }
            result = Math.max(result, curResult);
        }
        return result;
    }

    public int findLongest2(int[] input) {
        Map<Integer, Integer> visited = new HashMap<>();
        int[] parent = new int[input.length];
        int[] rank = new int[input.length];
        int[] size = new int[input.length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
            visited.put(input[i], i);
        }
        for (int i = 0; i < input.length; i++) {
            Integer previous = visited.get(input[i] - 1);
            Integer next = visited.get(input[i] + 1);
            if (previous != null) {
                safeUnion(parent, rank, i, previous);
            }
            if (next != null) {
                safeUnion(parent, rank, i, next);
            }
        }
        int result = 0;
        System.out.println(Arrays.toString(parent));
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] != -1) {
                size[parent[i]]++;
                result = Math.max(result,  size[parent[i]]);
            } else {
                size[i]++;
                result = Math.max(result,  size[i]);
            }
        }
        return result;
    }

    private int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    private void union(int[] parent, int[] rank, int i, int j) {
        if (rank[i] > rank[j]) {
            int tmp = i;
            i = j;
            j = tmp;
        }
        if (rank[i] == rank[j]) {
            rank[j]++;
        }
        parent[i] = j;
    }

    private void safeUnion(int[] parent, int[] rank, int i, int j) {
        int a = find(parent, i);
        int b = find(parent, j);
        if (a != b || a == -1) {
            union(parent, rank, a, b);
        }
    }

}
