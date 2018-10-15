package C15_DP3;

/**
 * Created by HaoYu on 2017/11/5.
 */
public class LargestXOf1s {
    public int largest(int[][] matrix) {
        // Write your solution here.
        int N = matrix.length;
        if (N == 0) {
            return 0;
        }
        int M = matrix[0].length;
        if (M == 0) {
            return 0;
        }
        int[][] upleft = new int[N][M];
        int[][] upright = new int[N][M];
        int[][] bottomleft = new int[N][M];
        int[][] bottomright = new int[N][M];
        int[][] result = new int[N][M];
        int globalMax = 0;

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    upleft[i][j] = getNumber(i - 1, j - 1, N, M, upleft) + 1;
                    upright[i][j] = getNumber(i - 1, j + 1, N, M, upright) + 1;
                }
            }
        }

        for(int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    bottomleft[i][j] = getNumber(i + 1, j - 1, N, M, bottomleft) + 1;
                    bottomright[i][j] = getNumber(i + 1, j + 1, N, M, bottomright) + 1;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    result[i][j] = Math.min(upleft[i][j], upright[i][j]);
                    result[i][j] = Math.min(result[i][j], bottomleft[i][j]);
                    result[i][j] = Math.min(result[i][j], bottomright[i][j]);
                    globalMax = Math.max(result[i][j], globalMax);
                } else {
                    result[i][j] = 0;
                }
            }
        }
        return globalMax;
    }

    private int getNumber(int i, int j, int N, int M, int[][] array) {
        if (i < 0 || i >= N || j < 0 || j >= M) {
            return 0;
        } else {
            return array[i][j];
        }
    }

    public static void main(String[] args){
        System.out.println(new LongestCrossOf1s().largest(new int[][] {
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 1} }
        ));
    }
}
