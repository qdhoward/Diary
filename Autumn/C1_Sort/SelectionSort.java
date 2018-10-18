package Autumn.C1_Sort;

import java.util.Arrays;

/**
 * Created by HaoYu on 2017/10/5.
 */
public class SelectionSort {
    public int[] solve(int[] array) {
        // Write your solution here.
        if (array == null || array.length == 1) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int globalMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[globalMin]) {
                    globalMin = j;
                }
            }
            swap(array, i, globalMin);
        }
        return array;
    }
    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
    public static void main(String[] args) {
        System.out.print(Arrays.toString(new SelectionSort().solve(new int[] {-2,-2})));
    }
}
