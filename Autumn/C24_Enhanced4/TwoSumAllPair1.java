package C24_Enhanced4;

import java.util.*;

/**
 * Created by HaoYu on 2017/12/4.
 */
public class TwoSumAllPair1 {
    public List<List<Integer>> allPairs(int[] array, int target) {
        // Write your solution here.
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> indexs = map.get(target - array[i]);
            if (indexs != null) {
                for (int j : indexs) {
                    res.add(Arrays.asList(j, i));
                }
            }
            if (!map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<>());
            }
            map.get(array[i]).add(i);
        }
        return res;
    }
    public static void main(String[] args){
        System.out.print(new TwoSumAllPair1().allPairs(new int[] {3, 5, 3, 2, 4, 4}, 7));
    }
}
