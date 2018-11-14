package LeetCode;

import java.util.*;

public class index {
    public static void main(String[] args) {
        WordBreak139 test = new WordBreak139();
        List<String> a = new ArrayList<String>();
        a.add("apple");
        a.add("pen");
        System.out.println(test.wordBreak("applepenapple", a));
    }
}
