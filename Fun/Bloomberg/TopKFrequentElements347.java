package Fun.Bloomberg;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements347 {
    class Pair {
        int num;
        int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        Pair[] array = new Pair[count.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            array[index] = new Pair(e.getKey(), e.getValue());
            index++;
        }
        quickSelect(array, 0, array.length - 1,  k - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(array[i].num);
        }
        return res;
    }

    private void quickSelect(Pair[] array, int left, int right, int target) {
        int mid = partition(array, left, right);
        if (mid == target) {
            return;
        } else if (mid > target) {
            quickSelect(array, left, mid - 1, target);
        } else {
            quickSelect(array, mid + 1, right, target);
        }
    }

    private int partition (Pair[] array, int left, int right) {
        int pivotIndex = left + (int) (Math.random() * (right - left + 1));
        int pivot = array[pivotIndex].freq;
        swap(array, pivotIndex, right);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound].freq > pivot) {
                leftBound++;
            } else if (array[rightBound].freq <= pivot) {
                rightBound--;
            } else {
                swap(array, leftBound++, rightBound--);
            }
        }
        swap(array, leftBound, right);
        return leftBound;
    }

    private void swap(Pair[] array, int left, int right) {
        Pair tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
    public static void main(String[] args) {
        System.out.println(
                new TopKFrequentElements347().topKFrequent(new int[] {1}, 1)
        );
    }
}
