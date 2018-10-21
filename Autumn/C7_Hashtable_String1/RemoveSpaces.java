package Autumn.C7_Hashtable_String1;

/**
 * Created by HaoYu on 2017/10/11.
 */
public class RemoveSpaces {
    public String removeSpaces(String input) {
        // Write your solution here.
        if (input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int f = 0;
        int s = 0;
        while (f < array.length) {
            if (array[f] == ' ' && (s == 0 || array[f - 1] == ' ')) {
                f++;
                continue; //TODO continue别忘了写！
            }
            array[s++] = array[f++];
        }
        if (s > 0 && array[s - 1] == ' ') {
            //TODO 还有可能最后尾部剩下一个空格
            return new String(array, 0, s - 1);
        }
        return new String(array, 0, s);
    }
    public static void main(String[] args){
        System.out.print(new RemoveSpaces().removeSpaces(" I Love Yahoo "));
    }

}
