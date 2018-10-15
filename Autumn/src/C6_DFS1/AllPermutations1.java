package C6_DFS1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HaoYu on 2017/10/5.
 */
public class AllPermutations1 {
    public List<String> permutations(String set) {
        // Write your solution here.
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        char[] array = set.toCharArray();
        DFS(array, 0, res);
        return res;
    }
    private void DFS(char[] array, int index, List<String> res) {
        if (index == array.length) {
            res.add(new String(array));
            return;
        }
        for (int i = index; i < array.length; i++) {
            // TODO i 从 index 开始！！
            swap(array, index, i);
            DFS(array, index + 1, res);
            swap(array, index, i);
        }
    }
    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public List<String> permutations2(String set) {
        //TODO 保持了字母的相对顺序，比如cab在cba前面
        // Write your solution here.
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        char[] array = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[array.length];
        DFS2(array, sb, used, res);
        return res;
    }
    private void DFS2(char[] array, StringBuilder sb, boolean[] used, List<String> res) {
        if (sb.length() == array.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (!used[i]) {
                used[i] = true;
                sb.append(array[i]);
                DFS2(array, sb, used, res);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(new AllPermutations1().permutations("abc"));
        System.out.print(new AllPermutations1().permutations2(""));
    }
}
