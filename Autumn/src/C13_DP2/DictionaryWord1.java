package C13_DP2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HaoYu on 2017/10/31.
 */
public class DictionaryWord1 {
    public boolean canBreak(String input, String[] dict) {
        // Write your solution here.
        Set<String> dictSet = new HashSet<>();
        for (String s : dict) {
            dictSet.add(s);
        }
        boolean[] check = new boolean[input.length() + 1];
        //TODO 边界corner case很难处理。此处check[i]表示0到i-1是不是在TF，因此check长度是+1！而且[0]是true!
        check[0] = true;
        //TODO 原因是我们用了substring，sub(i,j)其实是截取了到j-1的string
        //我们现在讲check长度加1而且将[0]设为true和用dummy node的道理很像
        for (int i = 1; i < input.length() + 1; i++) {
            for (int j= 0; j <= i; j++ ) {
                if (dictSet.contains(input.substring(j, i)) && check[j]) {
                    check[i] = true;
                    break;
                }
            }
        }
        return check[input.length()];
    }

    public boolean canBreak2(String input, String[] dict) {
        //TODO 这么写是不对的，因为[0]不管怎么样都是true,删了[0]=true就对了
        // Write your solution here.
        Set<String> dictSet = new HashSet<>();
        for (String s : dict) {
            dictSet.add(s);
        }
        boolean[] check = new boolean[input.length()];
        check[0] = true;
        for (int i = 0; i < input.length(); i++) {
            if (dictSet.contains(input.substring(0, i + 1))) {
                check[i] = true;
            } else {
                for (int j = 0; j <= i; j++) {
                    if (dictSet.contains(input.substring(j + 1, i + 1)) && check[j]) {
                        check[i] = true;
                        break;
                    }
                }
            }
        }
        return check[input.length() - 1];
    }

    public static void main(String[] args){
        System.out.println(new DictionaryWord1().canBreak2("bcdabc", new String[] {"abc","bcd","def"}));
        System.out.println(new DictionaryWord1().canBreak2("b", new String[] {"abc","bcd","def"}));
        System.out.println(new DictionaryWord1().canBreak2("abcd", new String[] {"a","bcd","def"}));
        System.out.println(new DictionaryWord1().canBreak2("abcd", new String[] {"abcd","bcd","def"}));
    }
}
