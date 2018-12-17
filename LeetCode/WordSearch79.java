package LeetCode;

public class WordSearch79 {
    private static int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (findWord(i, j, 0, board, visited, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean findWord(int i, int j, int index, char[][] board, boolean[][] visited, String word) {
        if (index == word.length()) {
            return true;
        }
        if (isOutOfBound(i, j, board.length, board[0].length)) {
            return false;
        }
        if (visited[i][j]) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        for (int[] direction: directions) {
            if (findWord(i + direction[0], j + direction[1], index + 1, board, visited, word)) {
                return true;
            }
        }
        visited[i][j] = false;//TODO Backtrack很重要！别忘了！
        return false;
    }
    private boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }
}
