package Autumn.C7_Hashtable_String1;

/**
 * Created by HaoYu on 2017/10/9.
 */
public class RemoveRepeatedCharactersI {
    public String deDup(String input) {
        // Write your solution here.
        if (input == null) {
            return null;
        }
        if (input.length() < 2) {
            return input;
        }
        int f = 1;
        int s = 0;
        char[] array = input.toCharArray();
        while (f < input.length()) {
            if (array[s] != array[f]) {
                array[++s] = array[f++];
            } else {
                f++;
            }
        }
        return new String(array, 0, s + 1);
        // TODO s+1 ！！！因为这道题是包括s的！
    }
}
