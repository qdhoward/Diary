package C8_String2;

/**
 * Created by HaoYu on 2017/10/11.
 */
public class RightShiftNCharacters {
    public String rightShift(String input, int n) {
        // Write your solution here.
        if (input == null || input.length() < 2) {
            return input;
        }
        char[] array = input.toCharArray();
        n = n % array.length;//TODO n可能大于array.length!!!
        reverse(array, 0, array.length - 1);
        reverse(array, 0, n - 1);
        reverse(array, n, array.length - 1);
        return new String(array);
    }

    private void reverse(char[] array, int start, int end) {
        while (start <= end) {
            char tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        System.out.print(new RightShiftNCharacters().rightShift("abcdef", 8));
    }
}
