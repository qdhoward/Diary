package LeetCode.Topic.String;

public class ReverseString344 {
    public String reverseString(String s) {
        if (s == null) {
            return s;
        }
        char[] array = s.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            swap(array, left++, right--);
        }
        return new String(array);
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
