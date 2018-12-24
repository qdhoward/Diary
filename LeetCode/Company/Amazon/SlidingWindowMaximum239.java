package LeetCode.Company.Amazon;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Amortized Time O(1)
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            //TODO 左边是栈顶（有效元素），那么要保证一旦栈顶元素出去，后面续上来的是最大的，所以要一直坚持右边的元素
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
