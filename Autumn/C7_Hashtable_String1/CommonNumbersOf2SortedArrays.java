package Autumn.C7_Hashtable_String1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HaoYu on 2017/10/7.
 */
public class CommonNumbersOf2SortedArrays {
    public List<Integer> common(List<Integer> A, List<Integer> B) {
        // Write your solution here.
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> countA = new HashMap<>();
        for (int a : A) {
            Integer num = countA.get(a);
            if (num == null) {
                countA.put(a, 1);
            } else {
                countA.put(a, num + 1);
            }
        }
        Map<Integer, Integer> countB = new HashMap<>();
        for (int b : B) {
            Integer num = countB.get(b);
            if (num == null) {
                countB.put(b, 1);
            } else {
                countB.put(b, num + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : countA.entrySet()) {
            Integer aInB = countB.get(entry.getKey());
            if (aInB != null) {
                int count = Math.min(aInB, entry.getValue());
                for (int i = 0; i < count; i++) {
                    res.add(entry.getKey());
                }
            }
        }
        return res;
    }
    private boolean BS(List<Integer> array, int n) {
        int left = 0;
        int right = array.size();
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array.get(mid) == n) {
                return true;
            } else if (array.get(mid) < n) {
                left = mid + 1;
            } else {
                right= mid - 1;
            }
        }
        return false;
    }
}
