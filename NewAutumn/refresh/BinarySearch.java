package NewAutumn.refresh;

public class BinarySearch {
    public int binarySearch(int[] array, int target) {
        // Write your solution here.
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //TODO 既然mid和target不等，那么完全可以将左/右移动一位。left <= right！比如只有两个数
        return -1;
    }


}
