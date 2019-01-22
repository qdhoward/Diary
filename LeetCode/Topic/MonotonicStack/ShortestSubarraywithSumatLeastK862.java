package LeetCode.Topic.MonotonicStack;

import java.util.Deque;
import java.util.LinkedList;

public class ShortestSubarraywithSumatLeastK862 {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }

        int res = Integer.MAX_VALUE;
        Deque<Integer> monoStack = new LinkedList();

        for (int i = 0; i < prefixSum.length; i++) {
            while (!monoStack.isEmpty() && prefixSum[i] <= prefixSum[monoStack.getLast()])
                monoStack.removeLast();
            while (!monoStack.isEmpty() && prefixSum[i] >= prefixSum[monoStack.getFirst()] + K)
                res = Math.min(res, i - monoStack.removeFirst());

            monoStack.addLast(i);
        }

        return res < Integer.MAX_VALUE ? res : -1;
    }
}
