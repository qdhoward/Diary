package Autumn.C2_BinarySearch;

/**
 * Created by HaoYu on 2017/9/30.
 */
public class LastOccurrence {
    public int lastOccur(int[] array, int target) {
        // Write your solution here
        if(array.length==0 || array==null){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left < right - 1){
            int mid  = left + (right-left)/2;
            if (array[mid] == target){
                left = mid;
            }
            else if(array[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        if(array[right] == target){
            return right;
        }
        if(array[left] == target){
            return left;
        }
        return -1;
    }
}
