package C18_Enhanced1;

import java.util.Arrays;

/**
 * Created by HaoYu on 2017/11/6.
 */
public class ArrayDeduplication2 {
    public int[] dedup(int[] array) {//TODO excluding s!
        // Write your solution here.
        if (array.length <= 2) {
            return array;
        }
        int s = 2;
        for (int f = 2; f < array.length; f++) {
            if (array[f] != array[s - 2]) {
                array[s++] = array[f];
            }
        }
        return Arrays.copyOf(array, s);
    }


    public int[] dedup2(int[] array) {//TODO including s!
        // Write your solution here.
        if (array.length <= 2) {
            return array;
        }
        int s = 1;
        for (int f = 2; f < array.length; f++) {
            if (array[f] != array[s - 1]) {
                array[++s] = array[f];
            }
        }
        return Arrays.copyOf(array, s + 1);
    }
}
