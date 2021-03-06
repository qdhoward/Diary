package Autumn.C2_BinarySearch;

/**
 * Created by HaoYu on 2017/9/30.
 */
public class FirstOccurrence {
    public int firstOccur(int[] array, int target) {
        // Write your solution here
        if(array == null || array.length == 0){
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left < right - 1){
            int mid  = left + (right - left)/2;
            if(array[mid] == target){
                right = mid;
            } else if(array[mid] < target){
                left = mid;
            } else {
                right = mid;
            }
        }
        if(array[left] == target){
            return left;
        } else if(array[right] == target){
            return right;
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(new FirstOccurrence().firstOccur(new int[]{1, 2},0));
    }
}
