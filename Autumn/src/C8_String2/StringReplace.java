package C8_String2;

/**
 * Created by HaoYu on 2017/10/11.
 */
public class StringReplace {
    public String replace(String input, String s, String t) {
        // Write your solution here.
        //TODO 如果inplace做的话，如果s < t的话，记住copy的时候要从input.length - 1开始copy，倒着来！！！
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int matchIndex = input.indexOf(s, 0);
        while (matchIndex != -1) {
            sb.append(input, start, matchIndex).append(t);
            start = matchIndex + s.length();
            matchIndex = input.indexOf(s, start);
        }
        sb.append(input, start, input.length());
        //TODO 最后还要把剩下的一段没有包含s的copy进去
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.print(new StringReplace().replace("aaa","aa",""));
    }
}
