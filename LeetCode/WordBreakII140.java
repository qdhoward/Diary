package LeetCode;


import java.util.*;

public class WordBreakII140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer, List<Integer>> backIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = -1; j <= i; j++) {
                if ((backIndex.containsKey(j) || j == -1) && wordDict.contains(s.substring(j + 1, i + 1))) {
                    if (!backIndex.containsKey(i)) {
                        backIndex.put(i, new ArrayList<>());
                    }
                    backIndex.get(i).add(j);
                }
            }
        }
        if (!backIndex.containsKey(s.length() - 1)) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        List<List<Integer>> indexResult = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(s.length() - 1);
        construct(backIndex, s.length() - 1, cur, indexResult);

        for (List<Integer> signal : indexResult) {
            StringBuilder sb = new StringBuilder();
            for (int i = signal.size() - 1; i >= 1; i--) {
                if (sb.length() != 0) {
                    sb.append(' ');
                }
                sb.append(s.substring(signal.get(i) + 1, signal.get(i - 1) + 1));
            }
            res.add(sb.toString());
        }
        return res;
    }
    public List<String> wordBreak2(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        List<String> res = new ArrayList<>();
        Map<Integer, List<Integer>> backIndex = new HashMap<>();
        helper(s, words, 0, backIndex);
        if (!backIndex.containsKey(s.length() - 1)) {
            return new ArrayList<>();
        }
        List<List<Integer>> indexResult = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(s.length() - 1);
        construct(backIndex, s.length() - 1, cur, indexResult);

        for (List<Integer> signal : indexResult) {
            StringBuilder sb = new StringBuilder();
            for (int i = signal.size() - 1; i >= 1; i--) {
                if (sb.length() != 0) {
                    sb.append(' ');
                }
                sb.append(s.substring(signal.get(i) + 1, signal.get(i - 1) + 1));
            }
            res.add(sb.toString());
        }
        return res;
    }

    private void construct(Map<Integer, List<Integer>> backIndex, int index, List<Integer> cur, List<List<Integer>> res) {
        if (index == -1) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (Integer next : backIndex.get(index)) {
            cur.add(next);
            construct(backIndex, next, cur, res);
            cur.remove(cur.size() - 1);
        }
    }

    private void helper(String s, Set<String> wordDict, int index, Map<Integer, List<Integer>> backIndex) {
        if (index == s.length()) {
            return;
        }
        for (int i = -1; i <= index; i++) {
            if ((backIndex.containsKey(i) || i == -1) && wordDict.contains(s.substring(i + 1, index + 1))) {
                if (!backIndex.containsKey(index)) {
                    backIndex.put(index, new ArrayList<>());
                }
                backIndex.get(index).add(i);
            }
        }
        helper(s, wordDict, index + 1, backIndex);
    }
}
