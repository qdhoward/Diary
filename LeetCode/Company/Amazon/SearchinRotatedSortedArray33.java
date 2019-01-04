package LeetCode.Company.Amazon;

public class SearchinRotatedSortedArray33 {
    public int search(int[] array, int target) {
        if (array == null || array.length == 0){
            return -1;
        }
        int left = 0, right = array.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if (array[mid] == target) return mid;
            if (array[mid] <= array[right]){// array[mid] < array[right] also OK
                if(target <= array[right] && target >= array[mid]){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }
            else{
                if (target < array[mid] && target >= array[left]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
        }
        return - 1;
    }
}
