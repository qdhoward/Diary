package LeetCode.Company.Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack155 {
    private Deque<Integer> dq1;
    private Deque<Integer> dq2;

    public MinStack155() {
        dq1 = new ArrayDeque<>();
        dq2 = new ArrayDeque<>();
    }

    public void push(int x) {
        dq1.offerFirst(x);
        if (dq2.isEmpty() || x <= dq2.peekFirst()) {
            dq2.offerFirst(x);
        }
    }

    public void pop() {
        int res = dq1.pollFirst();
        if (res == dq2.peekFirst()) {
            dq2.pollFirst();
        }

    }

    public int top() {
        return dq1.peekFirst();
    }

    public int getMin() {
        return dq2.peekFirst();
    }
}
