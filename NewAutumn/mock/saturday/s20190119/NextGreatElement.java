package NewAutumn.mock.saturday.s20190119;

import java.util.*;

public class NextGreatElement {
    public int[] getNextGreatElement (int[] array1, int[] array2) {
        //TreeMap T O(nlog(n))
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Map<Integer, Integer> rawResult = new HashMap<>();
        int[] result = new int[array1.length];
        for (int i = array2.length - 1; i >= 0; i--) {
            Map.Entry<Integer, Integer> next = map.ceilingEntry(array2[i]);
            if (next != null) {
                rawResult.put(array2[i], next.getValue());
            } else {
                rawResult.put(array2[i], -1);
            }
            map.put(array2[i], i);
        }

        for (int i = 0; i < array1.length; i++) {
            result[i] = rawResult.get(array1[i]);
        }
        return result;
    }

    public int[] getNextGreatElement2 (int[] array1, int[] array2) {
        //用单调栈 T O(n)
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> rawResult = new HashMap<>();
        int[] result = new int[array1.length];
        for (int i = array2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekFirst() < array2[i]) {
                stack.pollFirst();
            }
            rawResult.put(array2[i], stack.isEmpty() ? -1 : stack.peekFirst());
            stack.offerFirst(array2[i]);
        }

        for (int i = 0; i < array1.length; i++) {
            result[i] = rawResult.get(array1[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new NextGreatElement().getNextGreatElement2(
                        new int[] {4,1,2},
                        new int[] {1,3,4,2}
                )
        ));
    }
}
