package NewAutumn.mock.saturday.s20190216;

import java.util.Arrays;

public class FindNumOfClusters {
    public int countClusters(int n, int[][] edges) {
        int[] parents = new int[n];
        int[] ranks = new int[n];
        Arrays.fill(parents, -1);
        for (int i = 0; i < edges.length; i++) {
            safeUnion(edges[i][0], edges[i][1], parents, ranks);
        }
        int count = 0;
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == -1) {
                count++;
            }
        }
        return count;
    }

    private int find(int i, int[] parents) {
        if (parents[i] == -1) {
            return i;
        }
        return find(parents[i], parents);
    }

    private void union(int i, int j, int[] parents, int[] ranks) {
        if (ranks[i] > ranks[j]) {
            int tmp = i;
            i = j;
            j = tmp;
        }
        if (ranks[i] == ranks[j]) {
            ranks[j]++;
        }
        parents[i] = j;
    }

    private void safeUnion(int i, int j, int[] parent, int[] rank) {
        int a = find(i, parent);
        int b = find(j, parent);
        if (a != b) {
            union(a, b, parent, rank);
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindNumOfClusters().countClusters(
                6,
                new int[][] {
                        {0,1},
                        {4,2},
                        {4,5},
                        {1,3},
                        {1,5}
                }
        ));
    }
}
