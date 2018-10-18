package Autumn.C2_BinarySearch;

/**
 * Created by HaoYu on 2017/9/30.
 */
public class KClosest {
    public int[] kClosest(int[] array, int target, int k) {
        // Write your solution here
        int left = closest(array, target);
        int right = left + 1;
        int res[] = new int[k];
        for(int i = 0; i < k; i++){

            if(right >= array.length || (left >= 0 && Math.abs(array[left] - target) < Math.abs(array[right] - target))){
                res[i] = array[left--];
            } else {
                res[i] = array[right++];
            }
        }
        return res;
    }

    private int closest(int[] array, int target) {
        // Write your solution here
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
            return left;
        } else {
            return right;
        }
    }
}
