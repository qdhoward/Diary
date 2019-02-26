package util;
//Time O(2^n) Space O(n)
public class test {
    public static void main (String[] args) {
        System.out.println(maxSum(new int[] {-1,4,-5,-2,-1}));
    }

    static public int maxSum(int[] array) {
        int[] dp = new int[array.length];
        //dp[i] = Max(array[i] + dp[i - 2], dp[i - 1])
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);
        int res = 0;
        for (int i = 2; i < array.length; i++) {
            dp[i] = Math.max(array[i] + dp[i - 2], dp[i - 1]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
