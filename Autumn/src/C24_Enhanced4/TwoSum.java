package C24_Enhanced4;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HaoYu on 2017/12/4.
 */
public class TwoSum {
    public boolean existSum(int[] array, int target) {
        // Write your solution here.
        Set<Integer> remain = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (!remain.add(array[i])) {
                return true;
            } else {
                remain.add(target - array[i]);
            }
        }
        return false;
    }
}
