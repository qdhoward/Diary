package LeetCode.Amazon;

public class MaximumSwap670 {
    public int maximumSwap(int num) {
        char[] array = Integer.toString(num).toCharArray();
        int[] index = new int[10];
        for (int i = 0; i < array.length; i++) {
            index[array[i] - '0'] = i;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 9; j > array[i] - '0'; j--) {
                if (index[j] > i) {
                    swap(array, index[j], i);
                    return Integer.parseInt(new String(array));
                }
            }
        }
        return num;
    }

    private void swap(char[] array, int left, int right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
