package LeetCode.Topic.Array;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleinHistogram84 {
    public int largestRectangleArea(int[] heights) {
        //TODO 单调栈，维持的是以当前元素为结尾的增序列
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i <= heights.length; i++) {
            int cur = i == heights.length ? 0 : heights[i];
            while (!stack.isEmpty() && cur < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                res = Math.max(res, h * (i - left));
            }
            stack.push(i);
        }
        return res;
    }
}
