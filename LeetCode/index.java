package LeetCode;

import java.util.*;

public class index {
    public static void main(String[] args) {
        WordBreak139 test = new WordBreak139();
        List<String> a = new ArrayList<String>();
//        a.add("apple");
//        a.add("pen");
        WordLadder127 test2 = new WordLadder127();
        a.add("hot");
        a.add("dot");
        a.add("dog");
        a.add("lot");
        a.add("log");
        System.out.println(test2.ladderLength("hit", "cog", a));
    }
}
