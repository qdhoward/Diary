package C18_Enhanced1;

import java.util.Arrays;

/**
 * Created by HaoYu on 2017/11/6.
 */
public class LargestAndSmallest {
    public int[] largestAndSmallest(int[] array) {
        // Write your solution here.
        // The first element is the largest number,
        // the second element is the smallest number.
        int len = array.length - 1;
        for(int i = 0; i <= len / 2; i++){
            if(array[i] < array[len - i]){
                swap(array, i, len - i);
            }
        }
        return new int[]{max(array, 0, len / 2), min(array, len / 2, len)};
        //TODO 奇数的情况下，最中间的元素需要加到max和min两个函数中去！
    }

    private int max(int[] array, int left, int right){
        int max = array[left];
        for(int i = left; i <= right; i++){
            max = Math.max(array[i], max);
        }
        return max;
    }

    private int min(int[] array, int left, int right){
        int min = array[left];
        for(int i = left; i <= right; i++){
            min = Math.min(array[i], min);
        }
        return min;
    }

    private void swap(int[] array, int left, int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
    public static void main(String[] args){
        System.out.print(Arrays.toString(new LargestAndSmallest().largestAndSmallest(new int[] {2, 5, 1, 4, 3})));
    }
}
