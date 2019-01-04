package LeetCode.Topic.Array;

public class SpiralMatrixII59 {
    public int[][] generateMatrix(int n) {
        // Declaration
        int[][] matrix = new int[n][n];

        // Edge Case
        if (n == 0) {
            return matrix;
        }

        // Normal Case
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int num = 1; //change

        while (rowStart <= rowEnd && colStart <= colEnd) {
            //左右
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = num++; //change
            }
            rowStart++;
            //上下
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = num++; //change
            }
            colEnd--;
            //右左
            for (int i = colEnd; i >= colStart; i--) {
                if (rowStart <= rowEnd)
                    matrix[rowEnd][i] = num++; //change
            }
            rowEnd--;
            //下上
            for (int i = rowEnd; i >= rowStart; i--) {
                if (colStart <= colEnd)
                    matrix[i][colStart] = num++; //change
            }
            colStart++;
        }

        return matrix;
    }
}
