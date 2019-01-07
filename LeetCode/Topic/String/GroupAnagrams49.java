package LeetCode.Topic.String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String countString = convertIntoCount(s);
            if (!map.containsKey(countString)) {
                map.put(countString, new ArrayList<>());
            }
            map.get(countString).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String convertIntoCount(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : count) {
            sb.append(num);
            sb.append('#');
        }
        return sb.toString();
    }
}
