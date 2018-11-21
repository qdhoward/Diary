package LeetCode;

import java.util.*;

public class index {
    public static void main(String[] args) {
        WordBreakII140 test = new WordBreakII140();
        String[] cases = new String[] {"apple","pen","applepen","pine","pineapple"};
        List<String> cases2 = new ArrayList<>(Arrays.asList(cases));
        System.out.println(test.wordBreak("pineapplepenapple", cases2));
    }
}

