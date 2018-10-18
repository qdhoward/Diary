package C24_Enhanced4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HaoYu on 2018/1/24.
 */
public class TreeSum {
    public List<List<Integer>> allTriples(int[] array, int target) {
        // Write your solution here.
        Arrays.sort(array);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= array.length - 3; i++) {
            //TODO 因为必须满足三个元素才能找3sum，所以是-3
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
                //TODO 去重
            }
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int sum = array[left] + array[right];
                if (sum == target - array[i]) {
                    res.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    while (left < right && array[left] == array[left - 1]) {
                        left++;
                        //TODO 去重
                    }
                } else if (sum < target - array[i]) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
}
