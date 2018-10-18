package C24_Enhanced4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HaoYu on 2018/1/26.
 */
public class FourSum {
    static class Pair {
        int left;
        int right;
        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    public boolean exist(int[] array, int target) {
        // Write your solution here.
        Map<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                int sum = array[i] + array[j];
                Pair remain = map.get(target - sum);
                if (remain != null && remain.right < j) {
                    return true;
                }
                if (!map.containsKey(sum)) {
                    map.put(sum, new Pair(j, i));
                }
            }
        }
        return false;
    }
}
