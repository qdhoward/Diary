package C25_Enhanced5;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by HaoYu on 2018/1/24.
 */
public class LargestRectangle {
    public int largest(int[] array) {
        // Write your solution here.
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i <= array.length; i++) {
            int cur = i == array.length ? 0 : array[i];
            //TODO 手动地给最后一个元素加右边界，0
            while (!stack.isEmpty() && array[stack.peekFirst()] >= cur) {
                int height = array[stack.peekFirst()];
                int left = stack.isEmpty() ? 0 : stack.peekFirst();
                stack.pollFirst();
                //TODO 因为你之前poll了一个，所以这儿要+1
                res = Math.max(res, height * (i - left));
            }
            stack.offerFirst(i);
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println();
    }
}
