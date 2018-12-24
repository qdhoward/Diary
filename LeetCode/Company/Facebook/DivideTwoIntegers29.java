package LeetCode.Company.Facebook;

public class DivideTwoIntegers29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        return helper(dividend, divisor);
    }
    private int helper(int dividend, int divisor) {
        //TODO 全部转换为两个负数来做
        int res = 1;
        int factor = 1;
        if (dividend > 0 && divisor > 0) {
            dividend *= -1;
            divisor *= -1;
        } else if (dividend > 0 && divisor < 0) {
            dividend *= -1;
            factor = -1;
        } else if (dividend < 0 && divisor > 0) {
            divisor *= -1;
            factor = -1;
        }
        if (dividend > divisor) {
            return 0;
        }
        //TODO 判断每次double divisor后是否会越界
        int originalDivisor = divisor;
        while (dividend <= divisor + divisor && Integer.MIN_VALUE - divisor < divisor) {
            divisor += divisor;
            res += res;
        }
        return factor * (res + helper(dividend - divisor, originalDivisor));
    }
}
