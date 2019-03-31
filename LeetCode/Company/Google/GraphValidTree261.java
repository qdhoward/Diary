package LeetCode.Company.Google;

import java.util.Arrays;

public class GraphValidTree261 {
    public boolean validTree(int n, int[][] edges) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);

        for (int i = 0; i < edges.length; i++) {
            int x = find(parents, edges[i][0]);
            int y = find(parents, edges[i][1]);
            if (x == y) {
                return false;
            }
            parents[x] = y;
        }
        return edges.length == n - 1; // if it doesn't then there are more than one valid trees.
    }

    private int find(int nums[], int i) {
        if (nums[i] == -1) {
            return i;
        }
        return find(nums, nums[i]);
    }
}
