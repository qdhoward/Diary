//package NewAutumn.mock.saturday;
//
//import util.TreeNode;
//import util.TrieNode;
//
//import java.util.ArrayDeque;
//import java.util.Arrays;
//import java.util.Deque;
//import java.util.LinkedList;
//
//public class s_11_24_2018 {
//    int[][] directions = new int[][] {
//            new int[] {1, 0},
//            new int[] {-1, 0},
//            new int[] {0, 1},
//            new int[] {0, -1},
//    };
//
//    public static void main (String[] args) {
//        s_11_24_2018 test = new s_11_24_2018();
//        int[] res = test.closetHigher(new int[] {73, 74, 75, 71, 69, 72, 76, 73});
//        System.out.println(Arrays.toString(res));
//    }
//    public int[] closetHigher(int[] array) {
//        if (array == null || array.length == 0) {
//            return new int[0];
//        }
//        Deque<Integer> stack = new ArrayDeque<>();//TODO Linkedlist最适用于从中间remove元素
//        int[] res = new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//            while (!stack.isEmpty() && array[i] > array[stack.peekFirst()]) {
//                int index = stack.pollFirst();
//                res[index] = i - index;
//            }
//            stack.offerFirst(i);
//        }
//        return res;
//    }
//
//    public int largestCollection(String[] words, char[][] boards) {
//        TrieNode root = buildTrieTree(words);
//        for (int i = 0; i < boards.length; i++) {
//            for (int j = 0; j < boards[0].length; j++) {
//                boolean[][] visited = new boolean[boards.length][boards[0].length];
//                StringBuilder path = new StringBuilder();
//                int[] curMax = new int[1];
//                dfs(boards, i, j, visited, path, curMax);
//            }
//        }
//    }
//
//    private void dfs(char[][] boards, int i, int j, boolean[][] visited, StringBuilder path, int[] curMax) {
//        if ()
//        for (int[] direction: directions) {
//            int nexti = i + direction[0];
//            int nextj = j + direction[1];
//            if (!visited[nexti][nextj] && checkBoundary(nexti, nextj, boards.length, boards[0].length)) {
//                path.append(boards[nexti][nextj]);
//                dfs(boards, nexti, nextj, visited, path, curMax);
//                path.deleteCharAt(path.length() - 1);
//            }
//        }
//    }
//
//    private boolean checkBoundary(int i, int j, int x, int y) {
//        return i >= 0 && i < x && j >= 0 && j < y;
//    }
//
//
//    private TrieNode buildTrieTree(String[] words) {
//        TrieNode root = new TrieNode();
//        for (int i = 0; i < words.length; i++) {
//            root.insert(words[i], root);
//        }
//        return root;
//    }
//
//    public int maxWater(int[] array) {
//        int lmax = array[0];
//        int rmax = array[array.length - 1];
//        int left = 0;
//        int right = array.length - 1;
//        int res = 0;
//        while (left <= right) {
//            lmax = Math.max(lmax, array[left]);
//            rmax = Math.max(rmax, array[right]);
//            if (lmax < rmax) {
//                res += Math.max(0, lmax - array[left]);
//                left++;
//            } else {
//                res += Math.max(0, rmax - array[right]);
//                right--;
//            }
//        }
//        return res;
//    }
//}
