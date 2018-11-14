package LeetCode;

import java.util.List;

public class WordBreak139 {
    public boolean wordBreak_first(String s, List<String> wordDict) {
        return helper_first(s, wordDict, 0);
    }

    private boolean helper_first (String s, List<String> wordDict, int index) {
        if (index == s.length()) {
            return true;
        }
        boolean res = false;
        for (int i = 0; i < wordDict.size(); i++) {
            String sub = s.substring(index);
            if(sub.startsWith(wordDict.get(i))) {
                res = res || helper_first(s, wordDict, index + wordDict.get(i).length());
            }
        }
        return res;
    }
}
