package C15_DP3;


/**
 * Created by HaoYu on 2017/11/5.
 */
public class LongestCrossOf1s {
    public int largest(int[][] matrix) {
        int N = matrix.length;
        if (N == 0) {
            return 0;
        }
        int M = matrix[0].length;
        if (M == 0) {
            return 0;
        }
        int[][] leftright = new int[N][M];
        int[][] rightleft = new int[N][M];
        int[][] bottomup = new int[N][M];
        int[][] upbottom = new int[N][M];
        int[][] result = new int[N][M];
        int globalMax = 0;
        // Write your solution here.
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    if (j == 0) {
                        leftright[i][j] = 1;
                    } else {
                        leftright[i][j] = leftright[i][j - 1] + 1;
                    }
                } else {
                    leftright[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for (int j = M - 1; j >= 0; j--) {
                if (matrix[i][j] == 1) {
                    if (j == M - 1) {
                        rightleft[i][j] = 1;
                    } else {
                        rightleft[i][j] = rightleft[i][j + 1] + 1;
                    }
                } else {
                    rightleft[i][j] = 0;
                }
            }
        }

        for(int j = 0; j < M; j++) {
            for (int i = N - 1; i >= 0; i--) {
                if (matrix[i][j] == 1) {
                    if (i == N - 1) {
                        bottomup[i][j] = 1;
                    } else {
                        bottomup[i][j] = bottomup[i + 1][j] + 1;
                    }
                } else {
                    bottomup[i][j] = 0;
                }
            }
        }

        for(int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                if (matrix[i][j] == 1) {
                    if (i == 0) {
                        upbottom[i][j] = 1;
                    } else {
                        upbottom[i][j] = upbottom[i - 1][j] + 1;
                    }
                } else {
                    upbottom[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1) {
                    result[i][j] = Math.min(leftright[i][j], rightleft[i][j]);
                    result[i][j] = Math.min(result[i][j], bottomup[i][j]);
                    result[i][j] = Math.min(result[i][j], upbottom[i][j]);
                    globalMax = Math.max(result[i][j], globalMax);
                } else {
                    result[i][j] = 0;
                }
            }
        }
        // TODO java打印二维数组System.out.println(Arrays.deepToString(leftright));
        return globalMax;
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
