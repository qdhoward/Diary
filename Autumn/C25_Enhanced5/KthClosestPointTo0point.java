package C25_Enhanced5;


import java.util.*;

/**
 * Created by HaoYu on 2018/1/31.
 */
public class KthClosestPointTo0point {
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        // Write your solution here.
        PriorityQueue<List<Integer>> minheap = new PriorityQueue<>(2 * k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                long d1 = distance(a, b, c, o1);
                long d2 = distance(a, b, c, o2);
                if (d1 > d2) {
                    return 1;
                } else if (d1 == d2) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        Set<List<Integer>> visited = new HashSet<>();
        minheap.add(Arrays.asList(0, 0, 0));
        visited.add(Arrays.asList(0, 0, 0));
        while (k > 1) {
            List<Integer> cur = minheap.poll();
            List<Integer> next = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2));
            if (next.get(0) < a.length && visited.add(next)) {
                minheap.offer(next);
            }
            next = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
            if (next.get(1) < b.length && visited.add(next)) {
                minheap.offer(next);
            }
            next = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
            if (next.get(2) < c.length && visited.add(next)) {
                minheap.offer(next);
            }
            k--;
        }
        List<Integer> res =  minheap.poll();
        res.set(0, a[res.get(0)]);
        res.set(1, b[res.get(1)]);
        res.set(2, c[res.get(2)]);
        return res;
    }
    private long distance(int[] a, int[] b, int[] c, List<Integer> point) {
        return a[point.get(0)] * a[point.get(0)] + b[point.get(1)] * b[point.get(1)] + c[point.get(2)] * c[point.get(2)];
    }
}
