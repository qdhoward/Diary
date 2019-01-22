package NewAutumn.mock.saturday.s20190119;

import java.util.Arrays;

public class MinNumberOfBoat {
    public int getMin(int[] array, int limit) {
        //Assuming max(array[i]) <= limit
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        int res = 1;
        int remain = limit;
        while (left <= right) {
            if (remain - array[right] >= 0) {
                remain = remain - array[right];
                right--;
            } else if (remain - array[left] >= 0) {
                remain = remain - array[left];
                left++;
            } else {
                res++;
                remain = limit;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinNumberOfBoat().getMin(new int[] {3,4,5,6}, 6));
    }
}