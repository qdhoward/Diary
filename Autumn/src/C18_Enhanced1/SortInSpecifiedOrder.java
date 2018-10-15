package C18_Enhanced1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HaoYu on 2017/11/26.
 */
public class SortInSpecifiedOrder {
    private static class MyComparator implements Comparator<Integer> {
        Map<Integer, Integer> order;

        public MyComparator(int array[]) {
            order = new HashMap<>();
            for (int i = 0; i < array.length; i++) {
                order.put(array[i], i);
            }
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            Integer order1 = order.get(o1);
            Integer order2 = order.get(o2);
            if (order1 != null && order2 != null) {
                return order1.compareTo(order2);
            } else if (order1 == null && order2 == null) {
                return o1.compareTo(o2);
            } else {
                return order1 == null ? 1 : -1;
            }
        }
    }

    public int[] sortSpecial(int[] A1, int[] A2) {
        // Write your solution here.
        if (A1.length <= 1) {
            return A1;
        }
        Integer[] A3 = new Integer[A1.length];
        for (int i = 0; i < A1.length; i++) {
            A3[i] = A1[i];
        }
        Arrays.sort(A3, new MyComparator(A2));
        for (int i = 0; i < A1.length; i++) {
            A1[i] = A3[i];
        }
        return A1;
    }

    public static void main(String[] args) {
        System.out.print(Arrays.toString(new SortInSpecifiedOrder().sortSpecial(new int[]{4, 7, 9, 5, 1, 3, 2, 3, 6, 1}, new int[]{2, 4, 3, 1})));
    }
}
