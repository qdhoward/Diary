package C8_String2;

/**
 * Created by HaoYu on 2017/10/11.
 */
public class ReverseWordsInASentence1 {
    public String reverseWords(String input) {
        // Write your solution here.
        if (input == null || input.length() < 2) {
            return input;
        }
        char[] array = input.toCharArray();
        reverse(array, 0, array.length - 1);
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                start = i;
            }
            if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')) {
                reverse(array, start, i);
            }
        }
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
        System.out.print(new ReverseWordsInASentence1().reverseWords("Apple An"));
    }
}
