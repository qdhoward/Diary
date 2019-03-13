package NewAutumn.mock.saturday.s20190309;

import java.util.*;

public class findAllWords {
    public List<String> getAllWords(List<String> dict) {
        if (dict == null || dict.size() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word: dict) {
            set.add(word);
        }
        for (String word:dict) {
            if (checkWord(word, set)) {
                res.add(word);
            }
        }
        return res;
    }
    private boolean checkWord(String word, Set<String> dict) {
        if (!dict.contains(word)) {
            return false;
        }
        int[] dp = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j >= 0; j--) {
                String subWord = word.substring(j, i + 1);
                if (!subWord.equals(word) && dict.contains(subWord) && (j == 0 || dp[j - 1] != 0)) {
                    if (j == 0) {
                        dp[i] = 1;
                    } else {
                        dp[i] = Math.max(dp[j - 1] + 1, dp[i]);
                    }
                }
            }
        }
        return dp[word.length() - 1] >= 2;
    }

    public static void main(String[] args) {
        List<String> dict = new ArrayList<>();
        dict.add("face");
        dict.add("book");
        dict.add("facebook");
        dict.add("aa");
        dict.add("a");
        Set<String> set = new HashSet<>(dict);
        System.out.println(new findAllWords().getAllWords(dict));
    }
}
