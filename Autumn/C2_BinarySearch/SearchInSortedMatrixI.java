package Autumn.C2_BinarySearch;

/**
 * Created by HaoYu on 2017/9/30.
 */
public class SearchInSortedMatrixI {
    public int[] search(int[][] matrix, int target) {
        // Write your solution here.
        if(matrix == null || matrix.length ==0 || matrix[0].length == 0){
            return new int[] {-1, -1};
        }
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;
        while(left <= right){
            int middle = left + (right - left) / 2;
            int row = middle / matrix[0].length;
            int column = middle % matrix[0].length;
            if(matrix[row][column] == target){
                return new int[] {row, column};
            } else if (matrix[row][column] < target){
                left =  middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return new int[] {-1, -1};
    }
}
