package C18_Enhanced1;

import java.util.Arrays;

/**
 * Created by HaoYu on 2017/11/6.
 */
public class ArrayDeduplication4 {
    public int[] dedup(int[] array) {
        // Write your solution here.
        if (array.length <= 1) {
            return array;
        }
        int s = 0;
        int f = 1;
        while (f < array.length) {
            if (s == -1 || array[f] != array[s]) {
                array[++s] = array[f];
                f++;
            } else {
                while (f < array.length && array[f] == array[s]) {
                    f++;
                }
                s--;
            }
        }
        return Arrays.copyOf(array, s + 1);
    }
    // TODO 注意 s==-1的情况还有第二个while注意写条件f < array.length！
    public static void main(String[] args){
        System.out.print(Arrays.toString(new ArrayDeduplication4().dedup(new int[] {1, 1, 2, 2, 2, 3})));
    }
}
