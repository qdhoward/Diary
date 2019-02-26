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
        if (a != b) {
            union(parent, rank, a, b);
        }
    }

    /*
    Q2
    N couples sit in 2N seats arranged in a row and want to hold hands.
    We want to know the minimum number of swaps so that every couple is sitting side by side.
    A swap consists of choosing any two people, then they stand up and switch seats.
    The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order,
    the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).
    The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.

    Example 1:
    Input: row = [0, 2, 1, 3]
    Output: 1
    */
    public int minNumberOfSwap(int[] input) {
        int[] position = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            position[input[i]] = i;
        }
        int res = 0;
        for (int i = 0; i < input.length; i += 2) {
            if ((input[i] ^ 1) != input[i + 1]) {
                swap(input, i + 1, position[input[i] ^ 1]);
                res++;
            }
        }
        return res;
    }

    private void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }

    /*
    Bricks falling when hit https://leetcode.com/problems/bricks-falling-when-hit/
    */
    class Point{
        int x;
        int y;
        boolean isConnectedToTop;
        int size;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

//    class UnionFind{
//        Map<Point, Point> parent;
//        Map<Point, Integer> rank;
//
//        public UnionFind () {
//            Map<Point, Point> parent = new HashMap<>();
//            Map<Point, Integer> rank = new HashMap<>();
//        }
//
//        public Point find(Point p) {
//            if (parent.get(p) == null) {
//                return p;
//            }
//            parent.put(p, find(parent.get(p)));
//            return parent.get(p);
//        }
//
//        private Point union(Point i, Point j) {
//            if (rank.get(i) > rank.get(j)) {
//                Point tmp = i;
//                i = j;
//                j = tmp;
//            }
//            if (rank.get(i).equals(rank.get(j))) rank.put(j, rank.get(j) + 1);
//            parent.put(i, j);
//            return j;
//
//        }
//
//        public void safeUnion(Point i, Point j) {
//            Point a = find(i);
//            Point b = find(j);
//
//            if (a != b || a == null) {
//                union(i ,j);
//                j.size += i.size;
//                if (j.isConnectedToTop) {
//                    i.isConnectedToTop = true;
//                }
//                if (i.isConnectedToTop) {
//                    j.isConnectedToTop = true;
//                }
//            }
//        }
//    }
//
//    public int[] bricksFalling(int[][] grids, int[] hits) {
//        for (int i = 0; i < )
//    }
}
