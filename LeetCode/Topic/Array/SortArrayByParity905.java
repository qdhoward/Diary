package LeetCode.Topic.Array;

public class SortArrayByParity905 {
    public int[] sortArrayByParity(int[] A) {
        if(A.length <= 1) {
            return A;
        }
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            if (A[left] % 2 == 0) {
                left++;
            } else if (A[right] % 2 != 0) {
                right--;
            } else {
                swap(A, left, right);
                left++;
                right--;
            }
        }
        return A;
    }
    private void swap(int[] A, int left, int right) {
        int tmp = A[left];
        A[left] = A[right];
        A[right] = tmp;
    }
}
