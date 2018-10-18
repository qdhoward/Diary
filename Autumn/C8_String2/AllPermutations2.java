package C8_String2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by HaoYu on 2017/10/19.
 */
public class AllPermutations2 {
    public List<String> permutations(String set) {
        // Write your solution here.
        List<String> res = new ArrayList<>();
        if(set == null) {
            return res;
        }
        char[] array = set.toCharArray();
        permutations(array, 0, res);
        return res;
    }
    private void permutations(char[] array, int index, List<String> res) {
        if (index == array.length) {
            res.add(new String(array));
            return;
        }
        Set<Character> used = new HashSet<>();
        for (int i = index; i < array.length; i++) {
            if (!used.contains(array[i])) {
                used.add(array[i]);
                swap(array, index, i);
                permutations(array, index + 1, res);
                swap(array, index, i);
            }
        }
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
    public static void main(String[] args){
        System.out.print(new AllPermutations2().permutations("abbc"));
    }
}
