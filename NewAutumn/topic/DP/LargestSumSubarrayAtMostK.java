package NewAutumn.topic.DP;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestSumSubarrayAtMostK {
    public int maxSum(int[] array, int k) {
        int[] prefixSum = new int[array.length];
        int curSum = 0;
        for (int i = 0; i < array.length; i++) {
            curSum += array[i];
            prefixSum[i] = curSum;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return 0;
                }
                return o1[0] < o2[0] ? -1 : 1;
            }
        });

        int[] mins = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i >= k) {
                int[] cur = minHeap.peek();
                while(cur[1] < i - k) {
                    cur = minHeap.poll();
                }
                mins[i] = cur[0];
            }
            minHeap.offer(new int[] {prefixSum[i], i});
        }
//        System.out.println(Arrays.toString(mins));
//        System.out.println(Arrays.toString(prefixSum));
        int res = Integer.MIN_VALUE;
        for (int i = k; i < array.length; i++) {
            res = Math.max(res, prefixSum[i] - mins[i]);
        }
        return res;
    }
}
