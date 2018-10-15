package C13_DP2;

/**
 * Created by HaoYu on 2017/10/31.
 */
public class LargestSquareOf1s {
    public int largest(int[][] matrix) {
        // Write your solution here.
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int[][] num = new int[n][n];
        int numMax = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    //TODO 一定要记得处理初始边界！二维DP的时候一切后续结果都是由边界来的！
                    num[i][j] = matrix[i][j] == 0 ? 0 : 1;
                } else if (matrix[i][j] == 1){
                    num[i][j] = Math.min(num[i - 1][j] + 1, num[i][j - 1] + 1);
                    num[i][j] = Math.min(num[i - 1][j - 1] + 1, num[i][j]);
                } else {
                    num[i][j] = 0;
                }
                numMax = Math.max(numMax, num[i][j]);
            }
        }
        return numMax;
    }
    public static void main(String[] args){
        System.out.print(new LargestSquareOf1s().largest(new int[][]{{1}}));
    }
}
