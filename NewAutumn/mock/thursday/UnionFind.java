package NewAutumn.mock.thursday;

import java.util.*;

public class UnionFind {
    /*P1
    https://leetcode.com/problems/similar-string-groups/
    Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.
    e.g.
    “tars" and "rats" are similar
    but "star" is not similar to "tars", "rats"

    {"tars", "rats", "arts", "star"}
    Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.

    We are given a list A of strings.  Every string in A is an anagram of every other string in A.  How many groups are there?
    */
    public int naiveSolution(String[] array) {
        //TODO Time: O(n^2 * w) * O(uf) + O(n) = O(n^2 * w) and w is the average length of strings in array. Space: O(n)
        int[] parent = new int[array.length];
        int[] rank = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            parent[i] = -1;//一开始所有点都是小组长
            rank[i] = 0;
        }
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (isSimiliar(array[i], array[j])) {
                    union(i, j, parent, rank);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        return count;
    }

    private void union(int i, int j, int[] parent, int[] rank) {
        if (rank[i] > rank[j]) {
            int tmp = i;
            i = j;
            j = tmp;
        }
        if (rank[i] == rank[j]) {
            rank[j]++;
        }
        parent[i] = j;//TODO i是小树，j是大树, i的组长是j
    }

    private int find(int i, int[] parent) {
        if (parent[i] == -1) {
            return i;
        }
        parent[i] = find(parent[i], parent);
        return parent[i];

    }

    private boolean isSimiliar(String a, String b) {
        int left = 0;
        int right = a.length() - 1;
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (count == 0) {
                    left = i;
                } else {
                    right = i;
                }
                count++;
            }
        }
        if (count > 2) {
            return false;
        }
        return a.charAt(left) == b.charAt(right) && a.charAt(right) == b.charAt(left);
    }

    public int solution2(String[] array) {
        //TODO Time: O(n * w^3)  * O(uf) Space: O(n)
        int[] parent = new int[array.length];
        int[] rank = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            parent[i] = -1;
            rank[i] = 0;
        }
        Map<String, Integer> wordsToIndex = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            wordsToIndex.put(array[i], i);
        }
        for (int i = 0; i < array.length; i++) {
            int w = array[i].length();
            for (int j = 0; j < w - 1; j++) {
                for (int k = j + 1; k < w; k++) {
                    String similar = swap(array[i], j, k);
                    Integer index = wordsToIndex.get(similar);
                    if (index != null) {
                        //TODO 注意要check一下是否已经在一个组里面了
                        int parent1 = find(i, parent);
                        int parent2 = find(index, parent);
                        if (parent1 != parent2) union(i, index, parent, rank);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(parent));
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        return count;
    }

    private String swap(String s, int left, int right) {
        char[] array = s.toCharArray();
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
        return new String(array);
    }

    /*P2
    https://leetcode.com/problems/redundant-connection/
    The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added.
    Define a tree is an undirected graph that is connected and has no cycles.

    Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.


    Example 1:
    Input: [[1,2], [1,3], [2,3]]
    Output: [2,3]
    Explanation: The given undirected graph will be like this:
     1
    / \
    2 - 3
    */
    public int[] deleteExtraEdge(int[][] array) {
        //TODO Time O(n) Space O(number of treeNodes)
        int[] parent = new int[array.length * 2];
        int[] rank = new int[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            parent[i] = -1;
            rank[i] = 0;
        }
        for (int i = 0; i < array.length; i++) {
            int[] edge = array[i];
            union(edge[0], edge[1], parent, rank);
        }
        for (int i = array.length - 1; i > 0; i++) {
            int[] edge = array[i];
            if (find(edge[0], parent) == find(edge[1], parent)) {
                return edge;
            }
        }
        return null;
    }
}