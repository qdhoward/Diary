package util;

import java.util.*;

public class util {
    private static int[][] directions = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) {
    }

    private boolean isOutOfBound(int x, int y, int row, int col) {
        return x < 0 || x >= row || y < 0 || y >= col;
    }
}
