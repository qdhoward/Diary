package LeetCode.Topic.String;

public class ReverseWordsinaString151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] array = s.toCharArray();
        int end  = deleteExtraSpaces(array);
        reverse(array, 0, end);
        int start = 0;
        for (int i = 0; i <= end; i++) {
            if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                start = i;
            }
            if (array[i] != ' ' && (i == end || array[i + 1] ==' ')) {
                reverse(array, start, i);
            }
        }
        return new String(array, 0, end + 1);
    }

    private void reverse(char[] array, int left, int right) {
        while (left <= right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    private int deleteExtraSpaces(char[] array) {
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) {
                continue;
            }
            array[end++] = array[i];
        }
        if (end > 0 && array[end - 1] == ' ') {
            return end - 2;
        }
        return end - 1;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsinaString151().reverseWords("   a  "));
    }
}
