package C18_Enhanced1;

import java.util.Arrays;

/**
 * Created by HaoYu on 2017/11/6.
 */
public class ArrayDeduplication3 {
    public int[] dedup(int[] array) {
        // Write your solution here.
        if (array.length <= 1) {
            return array;
        }
        int s = 0;
        int begin = 0;
        int f = 0;
        while (f < array.length) {
            begin = f;
            while (f < array.length && array[f] == array[begin]) {
                f++;
            }
            if (f - begin == 1) {//TODO 两类不同元素的起点紧挨着，说明第一类元素一定只有一个！这道题excluding好写。
                array[s++] = array[begin];
            }
        }
        return Arrays.copyOf(array, s);
    }// TODO 需要三个指针！begin用来指示新元素的起点。注意第二个while循环不要忘记写条件f < array.length！

    public int[] dedup2(int[] array) {//TODO 双指针，不过这个写法和第四题一模一样了.....
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

    public static void main(String[] args){
        System.out.print(Arrays.toString(new ArrayDeduplication3().dedup2(new int[] {1, 2, 2, 2, 3})));
    }
}
