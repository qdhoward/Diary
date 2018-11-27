package LeetCode;

import java.util.*;

public class index {
    public static void main(String[] args) {
        WordSearchII212 test = new WordSearchII212();
        String[] words = new String[]{"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
        char[][] board = new char[][]{
                new char[]{'a', 'b'},
                new char[]{'c', 'd'}
        };
        System.out.println(test.findWords(board, words));
        System.out.println(test.findWords(board, words));
    }
}

