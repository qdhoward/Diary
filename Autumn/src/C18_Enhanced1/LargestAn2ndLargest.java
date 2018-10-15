package C18_Enhanced1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by HaoYu on 2017/11/7.
 */
public class LargestAn2ndLargest {
    static class Element {
        int value;
        List<Integer> comparedValues;
        Element(int value) {
            this.value = value;
            this.comparedValues = new ArrayList<Integer>();
        }
    }
    public int[] largestAndSecond(int[] array) {
        // Write your solution here.
        // The first element is the largest number,
        // the second element is the second largest number.
        Element[] helper = convert(array);
        int length = array.length;
        while (length > 1) {
            //这题选择size而不是index，因为选index的话，while条件是length > 0，这样会有死循环！
            //TODO 以后还是直接用size更好，index的corner case不好考虑
            compare(helper, length);
            length = (length + 1) / 2;//TODO 本题可以和比过的元素比，但是不能自己和自己比, 比如5可以和3比较好几次，但是5不能和5比
        }
        return new int[]{helper[0].value, largest(helper[0].comparedValues)};
    }
    private Element[] convert(int[] array) {
        Element[] helper = new Element[array.length];
        for (int i = 0; i < array.length; i++) {
            helper[i] = new Element(array[i]);
        }
        return helper;
    }
    private void compare(Element[] array, int end) {
        for (int i = 0; i < end / 2; i++) {//不能自己和自己比，所以不能写<=
            if (array[i].value < array[end - i - 1].value) {
                swap(array, i, end - i - 1);
            }
            array[i].comparedValues.add(array[end - i - 1].value);
            //只要发生过比较，不管换没换位，都得把小元素加到大元素的list里面去
        }
    }
    private void swap(Element[] array, int left, int right){
        Element tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
    private int largest(List<Integer> array) {
        int max = array.get(0);
        for (int num : array) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static void main(String[] args){
        System.out.print(Arrays.toString(new LargestAn2ndLargest().largestAndSecond(new int[] {2, 1, 5, 4, 3})));
    }
}
