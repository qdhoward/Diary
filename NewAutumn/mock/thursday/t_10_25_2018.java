package NewAutumn.mock.thursday;

public class t_10_25_2018 {
    public static void main(String[] args) {
        System.out.println(new t_10_25_2018().isTriagleArray(new int[] {1,2,3,3,3,2,1}));
        System.out.println(new t_10_25_2018().findPeak(new int[] {1,2,1}));
    }
    /*
    P1 1. check whether a array if a triangle array or not
    2. Find the max value in a triangle array
    */
    public boolean isTriagleArray(int[] array) {
        boolean flag = false;
        if (array == null || array.length < 3) {
            return false;
        }
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] <= array[i - 1] && i == 1) {
                return false;
            }
            if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
                if (flag) {
                    return false;
                } else {
                    flag = true;
                }
            }
        }
        return false;
    }

    public int findPeak(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
                return array[mid];
            } else if (array[mid - 1] < array[mid] && array[mid] < array[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    /*
    P2 Given a string containing only digits, e.g. "123456579";
    split it and output list of integer F such that  F[i] = F[i-1] + F[i-2];
    for i >= 2;  if not found, output empty list;
    */
}
