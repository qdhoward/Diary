package C21_Enhanced2;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by HaoYu on 2017/11/26.
 */
public class MergeKSortedArray {
    public int[] merge(int[][] arrayOfArrays) {
        // Write your solution here.
        PriorityQueue<Element> minHeap = new PriorityQueue<>(11, new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if (o1.value == o2.value) {
                    return 0;
                }
                return o1.value < o2.value ? -1 : 1;
            }
        });
        int length = 0;
        for (int i = 0; i < arrayOfArrays.length; i++) {
            length += arrayOfArrays[i].length;
            if (arrayOfArrays[i].length != 0) {
                minHeap.add(new Element(i, 0, arrayOfArrays[i][0]));
            }
        }
        int[] res = new int[length];
        int index = 0;
        while (!minHeap.isEmpty()) {
            Element next = minHeap.poll();
            res[index++] = next.value;
            if (next.y + 1 < arrayOfArrays[next.x].length) {
                next.y++;
                next.value = arrayOfArrays[next.x][next.y];
                minHeap.offer(next);
                //TODO 复用刚刚poll出来的元素，不用开辟新的空间了
            }
        }
        return res;
    }
    static class Element {
        int x;
        int y;
        int value;
        public Element(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
