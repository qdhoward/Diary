package LeetCode.Topic.Array;

public class ArrayPartition1 {
    public int arrayPairSum(int[] nums) {
        //TODO arr是frequency map
        int[] arr = new int[20001];
        int lim = 10000;
        for (int num: nums)
            arr[num + lim]++;
        int d = 0, sum = 0;
        for (int i = -10000; i <= 10000; i++) {
            while (arr[i + lim] == 0 && i < 10000) {
                i++;
            }
            sum += (arr[i + lim] + 1 - d) / 2 * i;
            d = (arr[i + lim] - d) % 2;
        }
        return sum;
    }
}
