package C6_DFS1;

import C3_LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HaoYu on 2017/10/5.
 */
public class AllSubsets1 {
    public List<String> subSets(String set) {
        // Write your solution here.
        List<String> res = new ArrayList<>();
        if (set == null) {
            //TODO 不用写set.length() == 0，因为空集也算一个子集
            return res;
        }
        char[] array = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        Dfs(array, 0, sb, res);
        return res;
    }
    private void Dfs(char[] array, int index, StringBuilder sb, List<String> res) {
        if (index >= array.length) {
            res.add(sb.toString());
            return;
        }
        Dfs(array, index + 1, sb.append(array[index]), res);
        sb.deleteCharAt(sb.length() - 1);
        Dfs(array, index + 1, sb, res);
    }

}
