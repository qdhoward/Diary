package LeetCode.Company.Amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {
    public boolean wordBreak_first(String s, List<String> wordDict) {
        return helper_first(s, wordDict, 0);
    }

    private boolean helper_first (String s, List<String> wordDict, int index) {
        if (index == s.length()) {
            return true;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            String sub = s.substring(index);
            if(sub.startsWith(wordDict.get(i)) && helper_first(s, wordDict, index + wordDict.get(i).length())) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak_memo(String s, List<String> wordDict) {
        return helper(s, wordDict, 0, new int[s.length()]);
    }

    private boolean helper(String s, List<String> wordDict, int index, int[] dp) {
        if (index == s.length()) {
            return true;
        }
        if (dp[index] != 0) {
            return dp[index] == 1;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            String sub = s.substring(index);
            if(sub.startsWith(wordDict.get(i)) && helper(s, wordDict, index + wordDict.get(i).length(), dp)) {
                dp[index] = 1;
                return true;
            }
        }
        dp[index] = -1;
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = s.length(); j >= i; j--) {
                if (dp[j] && words.contains(s.substring(i, j))) {
                    dp[i] = true;
                }
            }
        }
        return dp[0];
    }
}
