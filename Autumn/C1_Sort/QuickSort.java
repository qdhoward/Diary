package Autumn.C1_Sort;

/**
 * Created by HaoYu on 2017/10/3.
 */
public class QuickSort {
    public int[] quickSort(int[] array) {
        // Write your solution here
        if (array == null) {
            return null;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }
    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(array, left, right);
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }
    private int partition(int[] array, int left, int right) {
        int index = left + (int) (Math.random() * (right - left + 1));
        int pivot = array[index];
        swap(array, index, right); //swap index! not pivot.
        int leftbound = left;
        int rightbound = right - 1;
        while (leftbound <= rightbound) {
            if (array[leftbound] < pivot) {
                leftbound++;
            } else if (array[rightbound] >= pivot) {
                rightbound--;
            } else {
                swap(array, leftbound, rightbound);
                leftbound++;
                rightbound--;
            }
        }
        swap(array, leftbound, right); // swap it bcak after the while loop!
        return leftbound;
    }
    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
    public static void main(String[] args) {
        System.out.println(new QuickSort().quickSort(new int[]{4,2,1,6,3,5}));
    }
}
