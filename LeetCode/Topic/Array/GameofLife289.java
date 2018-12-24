package LeetCode.Topic.Array;

public class GameofLife289 {
    private static int[][] directions = new int[][] {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {-1, 1}, {1, -1}, {-1, -1}
    };

    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int liveCount = 0;
                for (int[] direction : directions) {
                    int nextI = i + direction[0];
                    int nextJ = j + direction[1];
                    if (!outOfBoundary(nextI, nextJ, board.length, board[0].length) &&
                            (board[nextI][nextJ] == 1 || board[nextI][nextJ] == 2)) {
                        liveCount += 1;
                    }
                }
                if (board[i][j] == 1 && (liveCount < 2 || liveCount > 3)) {
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && liveCount == 3) {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private boolean outOfBoundary(int i, int j, int row, int col) {
        return i < 0 || i >= row || j < 0 || j >= col;
    }
}
