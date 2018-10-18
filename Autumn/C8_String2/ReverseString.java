package C8_String2;

/**
 * Created by HaoYu on 2017/10/11.
 */
public class ReverseString {
    public String reverse(String input) {
        // Write your solution here.
        if (input == null || input.length() < 2) {
            return input;
        }
        char[] array = input.toCharArray();
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            swap(array, i, j);
        }
        return new String(array);
    }
    private void swap (char[] array, int l, int r) {
        char tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }
}
