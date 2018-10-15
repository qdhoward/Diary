package C24_Enhanced4;

import java.util.*;

/**
 * Created by HaoYu on 2018/1/26.
 */
public class TwoSumAllPair2 {
    public List<List<Integer>> allPairs(int[] array, int target) {
        // Write your solution here.
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : array) {
            Integer count = map.get(num);
            if (num * 2 == target && count != null && count == 1) {
                res.add(Arrays.asList(num, num));
            }
            if (map.containsKey(target - num) && count == null) {
                res.add(Arrays.asList(num, target - num));
            }
            if (count == null) {
                map.put(num, 1);
            } else {
                map.put(num, count + 1);
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(new TwoSumAllPair2().allPairs(new int[] {2, 1, 3, 2, 4, 3, 4, 2}, 6));
    }
}
