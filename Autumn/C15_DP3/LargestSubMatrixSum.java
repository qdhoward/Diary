package C15_DP3;

import java.util.Arrays;

/**
 * Created by HaoYu on 2017/11/5.
 */
public class LargestSubMatrixSum {
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
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int[] cur = new int[M];//TODO 这个trick就是在内层循环可以边循环边算拍扁的矩阵，不用另起一个循环了
            for (int j = i; j < N; j++) {
                for (int h = 0; h < M; h++) {
                    cur[h] += matrix[j][h];
                }
                result = Math.max(result, maxSubarray(cur));
            }
        }
        return result;
    }
    private int maxSubarray(int[] array) {
        int cur = array[0];
        int globalMAx = array[0];
        for (int i = 1; i < array.length; i++) {
            cur = Math.max(cur + array[i], array[i]);
            globalMAx = Math.max(globalMAx, cur);
        }
        return globalMAx;
    }

    public int largest2(int[][] matrix) {
        int N = matrix.length;
        if (N == 0) {
            return 0;
        }
        int M = matrix[0].length;
        if (M == 0) {
            return 0;
        }
        int[][] sum = prefisSum(matrix);
        int cur = 0;
        int result = Integer.MIN_VALUE;
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < M; b++) {
                for (int c = a; c < N; c++) {
                    for (int d = b; d < M; d++) {
                        if (a == 0 && b == 0) {
                            cur = sum[c][d];
                        } else if (a == 0) {
                            cur = sum[c][d] - sum[c][b - 1];
                        } else if (b == 0) {
                            cur = sum[c][d] - sum[a - 1][d];
                        } else {
                            cur = sum[c][d] - sum[a - 1][d] - sum[c][b - 1] + sum[a - 1][b - 1];
                        }
                        result = Math.max(cur, result);
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(sum));
        return result;
    }

    private int[][] prefisSum(int[][] array) {
        int N = array.length;
        int M = array[0].length;
        int[][] res = new int[N][M];
        for (int i = 0; i < N; i++) {
            int cur = 0;
            for (int j = 0; j < M; j++) {
                cur += array[i][j];
                if (i == 0) {
                    res[i][j] = cur;
                } else {
                    res[i][j] = res[i - 1][j] + cur;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(new LargestSubMatrixSum().largest2(new int[][] {
                {1, -2, -1, 4},
                {1, -1,  1, 1},
                {0, -1, -1, 1},
                {0,  0,  1, 1} }
        ));
    }
}
