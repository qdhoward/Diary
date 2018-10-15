package C18_Enhanced1;

/**
 * Created by HaoYu on 2017/11/7.
 */
public class RotateMatrix {
    public void rotate(int[][] matrix) {
        // Write your solution here.
        int n = matrix.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {//TODO 只跑一半就好了
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = tmp;
            }
        }
        //TODO y轴镜像，y=x镜像
    }
}
