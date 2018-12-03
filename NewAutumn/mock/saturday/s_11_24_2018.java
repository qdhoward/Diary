package NewAutumn.mock.saturday;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class s_11_24_2018 {
    int[][] directions = new int[][] {
            new int[] {1, 0},
            new int[] {-1, 0},
            new int[] {0, 1},
            new int[] {0, -1},
    };

    public static void main (String[] args) {
        s_11_24_2018 test = new s_11_24_2018();
        int[] res = test.closetHigher(new int[] {73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(res));
    }
    public int[] closetHigher(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }
        Deque<Integer> stack = new ArrayDeque<>();//TODO Linkedlist最适用于从中间remove元素
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[i] > array[stack.peekFirst()]) {
                int index = stack.pollFirst();
                res[index] = i - index;
            }
            stack.offerFirst(i);
        }
        return res;
    }

    public int maxWater(int[] array) {
        int lmax = array[0];
        int rmax = array[array.length - 1];
        int left = 0;
        int right = array.length - 1;
        int res = 0;
        while (left <= right) {
            lmax = Math.max(lmax, array[left]);
            rmax = Math.max(rmax, array[right]);
            if (lmax < rmax) {
                res += Math.max(0, lmax - array[left]);
                left++;
            } else {
                res += Math.max(0, rmax - array[right]);
                right--;
            }
        }
        return res;
    }
}
