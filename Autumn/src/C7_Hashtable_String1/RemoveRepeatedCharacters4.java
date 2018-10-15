package C7_Hashtable_String1;

/**
 * Created by HaoYu on 2017/10/9.
 */
public class RemoveRepeatedCharacters4 {
    public String deDup(String input) {
        // Write your solution here.
        if (input == null) {
            return null;
        }
        if (input.length() < 2) {
            return input;
        }
        char[] array = input.toCharArray();
        int s = 0;
        int f = 1;
        while (f < array.length) {
            if (s < 0 || array[s] != array[f]) {
                array[++s] = array[f++];// TODO 包括s
            } else {
                while (f < array.length && array[s] == array[f]) {
                    // TODO 涉及到array的操作，一定要记得判断是否出界！
                    f++;
                }
                s--;
            }
        }
        return new String(array, 0, s + 1);
    }
}
