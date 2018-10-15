package C15_DP3;

import java.util.Arrays;

/**
 * Created by HaoYu on 2017/11/5.
 */
public class LargestSubsquare {
    public int Largest(int[][] matrix) {
        int N = matrix.length;
        if (N == 0) {
            return 0;
        }
        int M = matrix[0].length;
        if (M == 0) {
            return 0;
        }
        int[][] rightleft = new int[N][M];
        int[][] bottomup = new int[N][M];
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = M - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (j == M - 1) {
                        rightleft[i][j] = 1;
                    } else {
                        rightleft[i][j] = rightleft[i][j + 1] + 1;
                    }
                }
            }
        }

        for (int j = 0; j < M; j++) {
            for (int i = N - 1; i >= 0; i--) {
                if (matrix[i][j] == 1) {
                    if (i == N - 1) {
                        bottomup[i][j] = 1;
                    } else {
                        bottomup[i][j] = bottomup[i + 1][j] + 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    for (int length = Math.min(rightleft[i][j], bottomup[i][j]); length >= 1; length--) {
                        if (bottomup[i][j + length - 1] >= length && rightleft[i + length - 1][j] >= length) {
                            result = Math.max(result, length);
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(rightleft));
        System.out.println(Arrays.deepToString(bottomup));
        return result;
    }
    public static void main(String[] args){
        System.out.println(new LargestSubsquare().Largest(new int[][] {
                {1,0,1,1,1},
                {1,1,1,1,1},
                {1,1,0,1,0},
                {1,1,1,1,1},
                {1,1,1,0,0}}
        ));
    }
}
