package Autumn.C5_Heap_BFS1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by HaoYu on 2017/10/3.
 */
public class KSmallestInUnsortedArray {
    class myComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer a1, Integer a2) {
            if (a1.equals(a2)) {
                return 0;
            }
            return a1 > a2 ? -1 : 1;
        }
    }
    public int[] kSmallest1(int[] array, int k) {
        if (array.length == 0 || k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new myComparator());
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.add(array[i]);
            } else if (array[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(array[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[k - 1 - i] = maxHeap.poll();//用的是maxHeap，最后输出的时候记得倒序！
        }
        return res;
    }

    public int[] kSmallest2(int[] array, int k) {
        // Write your solution here
        if (array.length == 0 || k == 0) {
            return new int[0];
        }
        quickSelect(array, 0, array.length - 1, k - 1);
        // index是0开始，所以index是k-1
        int[] res = Arrays.copyOf(array, k);
        Arrays.sort(res);
        return res;
    }
    private void quickSelect(int[] array, int left, int right, int k) {
        int index = partition(array, left, right);
        if (index == k) {
            return;
        } else if (index > k) {
            quickSelect(array, left, index - 1, k);
        } else {
            quickSelect(array,index + 1, right, k);
        }
    }
    private int partition(int[] array, int left, int right) {
        int index = left + (int) (Math.random() * (right - left + 1));
        int pivot = array[index];
        swap(array, index, right);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] < pivot) {
                leftBound++;
            } else if (array[rightBound] >= pivot) {
                rightBound--;
            } else {
                swap(array, leftBound++, rightBound--);
            }
        }
        swap(array, leftBound, right);
        return leftBound;
    }
    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
