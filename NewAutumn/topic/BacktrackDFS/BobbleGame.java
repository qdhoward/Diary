package NewAutumn.topic.BacktrackDFS;

import util.TrieNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BobbleGame {
    private static int[][] directions = new int[][] {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };
    public boolean singleCase(char[][] matrix, String target) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        visited[0][0] = true;
        return singleCaseDFS(matrix, target, 0, 0, 0, visited);
    }
    private boolean singleCaseDFS(char[][] matrix, String target, int index, int x, int y, boolean[][] visited) {
        //base case
        if (index == target.length()) { //1.触底那么表示成功
            return true;
        }
        if (x < 0 || x >= matrix[0].length || y < 0 || y >= matrix.length) { //2.检查array边界
            return false;
        }
        if (visited[x][y]) {// 3.判断是否访问过
            return false;
        }
        if (matrix[x][y] != target.charAt(index)) { // 4.当前层是否满足条件
            return false;
        }
        visited[x][y] = true;
        for (int[] direction : directions) {
            if (singleCaseDFS(matrix, target, index + 1, x + direction[0], y + direction[1], visited)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    public List<String> manyCases(char[][] matrix, String target) {
        TrieNode root = new TrieNode();
        return new ArrayList<>();
        //TODO use trie tree to group all common prefix;
    }

    public List<List<String>> wordSqure(String[] words) {
        //Time O(4!) Space(4)
        List<List<String>> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        Set<String> added = new HashSet<>();
        for (String word : words) {
            root.insert(word, root);
        }
        for (String word : words) {
            List<String> curRes = new ArrayList<>();
            curRes.add(word);
            added.add(word);
            res.remove(res.size() - 1);
            if (curRes.size() == 4) {
                res.add(curRes);
            }
        }
        return res;
    }

    private void wordSqureHelper(String[] words, List<String> res, int level, TrieNode root, Set<String> added) {
        if (level == 3) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append(res.get(i).charAt(level));
        }
        List<String> nextWords = root.prefixSearch(sb.toString(), root);
        for (String word : nextWords) {
            if (!added.contains(word)) {
                wordSqureHelper(words, res, level + 1, root, added);
            }
        }
    }
}
