package Autumn.C7_Hashtable_String1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by HaoYu on 2017/10/11.
 */
public class RemoveCertainCharacters {
    public String remove(String input, String t) {
        // Write your solution here.
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        int s = 0;
        char[] array = input.toCharArray();
        for (int f = 0; f < input.length(); f++) {
            if (set.contains(array[f])) {
                continue;
            }
            array[s++] = array[f];
        }
        return new String(array, 0, s);
    }
}
