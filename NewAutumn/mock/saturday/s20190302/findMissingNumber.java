package NewAutumn.mock.saturday.s20190302;

public class findMissingNumber {
    public int missingNumber(int[] array) {
        if (array == null || array.length  % 2 == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
//            if (mid == array.length - 1) {
//                return array[mid];
//            }
            if (mid % 2 == 0 && array[mid] == array[mid + 1] || mid % 2 == 1 && array[mid] == array[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return array[left];
    }
    public static void main(String[] args) {
        System.out.println(new findMissingNumber().missingNumber(
                new int[] {1,1,2,2,3,3,4}
        ));
    }
}
