package Autumn.Midterm2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HaoYu on 2017/11/14.
 */
public class printIfBlocks {
    public void printIf(int n) {
        if (n <= 0) {
            return;
        }
        List<String> cur = new ArrayList<>();
        helper(n, n, cur);
    }
    private void helper(int left, int right, List<String> cur) {
        if (left == 0 && right == 0) {
            printBlocks(cur);
            System.out.println("**********");
            return;
        }
        if (left > 0) {
            cur.add("{");
            helper(left - 1, right, cur);
            cur.remove(cur.size() - 1);
        }
        if (right > left) {
            cur.add("}");
            helper(left, right - 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
    private void printBlocks(List<String> cur) {
        int count = 0;
        for (String s : cur) {
            if (s.equals( "{")) {
                printSpaces(count);
                System.out.println("if{");
                count++;
            }
            if (s.equals("}")) {
                //TODO 要先减！！
                count--;
                printSpaces(count);
                System.out.println("}");
            }
        }
    }
    private void printSpaces(int n) {
        while (n > 0) {
            System.out.print("   ");
            n--;
        }
    }
    public static void main(String[] args){
        new printIfBlocks().printIf(3);
    }
}
