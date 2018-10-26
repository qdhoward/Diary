package NewAutumn.refresh.Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KSmallestInUnsortedArray {
    public int[] kSmallest(int[] array, int k) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                }
                return o1 > o2 ? -1 : 1;
            }
        });
        for (int i = 0; i < array.length; i++) {
            if (i < k) {
                maxHeap.offer(array[i]);
            } else {
                if (array[i] < maxHeap.peek()) {
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }

        }
        int[] result = new int[k];
        for (int i = k - 1; i > 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    public int[] kSmallest2(int[] array, int k) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        quickselect(array, 0, array.length, k);
        int[] result = Arrays.copyOf(array, k);
        Arrays.sort(result);// It may not be necessary.
        return result;
    }
    private void quickselect(int[] array, int left, int right, int targetIndex) {
        int mid = partition(array, left, right);
        if (mid == targetIndex) {
            return;
        } else if (mid < targetIndex) {
            quickselect(array, mid + 1, right, targetIndex);
        } else {
            quickselect(array, left, mid - 1, targetIndex);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        int pivot = array[pivotIndex];
        int start = left;
        int end = right - 1;
        swap(array, pivotIndex, right);
        while (start <= end) {
            if (array[start] < pivot) {
                start++;
            } else if (array[end] >= pivot) {
                end--;
            } else {
                swap(array, start++, end--);
            }
        }
        swap(array, pivotIndex, right);
        return pivotIndex;
    }

    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }


}
