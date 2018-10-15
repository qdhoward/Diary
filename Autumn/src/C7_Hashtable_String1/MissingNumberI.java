package C7_Hashtable_String1;

/**
 * Created by HaoYu on 2017/10/7.
 */
public class MissingNumberI {
    public int missing(int[] array) {
        // Write your solution here.
        if (array.length == 0) {
            return 1;
        }
        int xor = 0;
        for (int i = 0; i < array.length; i++) {
            xor ^= array[i];
        }
        for (int i = 1; i <= array.length + 1; i++) {
            //TODO 好好看题！这儿得是array.length + 1！
            xor ^= i;
        }
        return xor;
    }
}
