package LeetCode.Amazon;

import java.util.*;

public class AlienDictionary269 {
    //TODO 拓扑排序
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> dependency = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        String result = "";
        if (words == null || words.length == 0) return result;
        for (String s : words) {
            for (char c : s.toCharArray()) {
                degree.put(c, 0);
            }
        }
        buildDependencyGraph(words, dependency, degree);
        Queue<Character> q = new LinkedList<>();
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) q.add(c);
        }
        while (!q.isEmpty()) {
            char c = q.remove();
            result += c;
            if (dependency.containsKey(c)) {
                for (char c2 : dependency.get(c)) {
                    degree.put(c2, degree.get(c2) - 1);
                    if (degree.get(c2) == 0) q.add(c2);
                }
            }
        }
        if (result.length() != degree.size()) {
            return "";
        }
        return result;
    }

    private void buildDependencyGraph(String[] words, Map<Character, Set<Character>> dependency, Map<Character, Integer> degree) {
        for (int i = 0; i < words.length - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int length = Math.min(cur.length(), next.length());
            for (int j = 0; j < length; j++) {
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2) {
                    Set<Character> set = new HashSet<>();
                    if (dependency.containsKey(c1)) {
                        set = dependency.get(c1);
                    }
                    if (!set.contains(c2)) {
                        set.add(c2);
                        dependency.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
    }
}
