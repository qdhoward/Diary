package LeetCode.Topic.Array;

import java.util.Arrays;

public class MaximalRectangle85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int[][] prefixSum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0) {
                    prefixSum[0][j] = matrix[0][j] == '0' ? 0 : 1;
                } else {
                    prefixSum[i][j] = matrix[i][j] == '0' ? prefixSum[i - 1][j] : prefixSum[i - 1][j] + 1;
                }
            }
        }
        int res = 0;
        //TODO 用行数确定边界的时候注意j从i开始
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int[] array = new int[matrix[0].length];
                for (int k = 0; k < matrix[0].length; k++) {
                    array[k] = i == 0 ? prefixSum[j][k] : prefixSum[j][k] - prefixSum[i - 1][k];
                }
                int diff = j - i + 1;
                int max = findLongestContiniousArray(array, diff) * diff;
                res = Math.max(res, max);
            }
        }
        return res;
    }

    private int findLongestContiniousArray(int[] array, int target) {
        //TODO 不开辟新的空间的话，注意base case第一个元素就要override
        array[0] = array[0] == target ? 1 : 0;
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] == target) {
                array[i] = array[i - 1] + 1;
            } else {
                array[i] = 0;
            }
            res = Math.max(res, array[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaximalRectangle85().maximalRectangle(
                new char[][] {
                        {'1', '1'},
                        {'1', '1'}
                }
        ));
    }
}
