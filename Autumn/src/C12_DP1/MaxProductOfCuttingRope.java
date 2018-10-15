package C12_DP1;

/**
 * Created by HaoYu on 2017/10/29.
 */
public class MaxProductOfCuttingRope {
    public int maxProduct(int length) {
        // Write your solution here.
        int[] m = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            int curMax = 0;
            for (int j = 1; j <= i; j++) {
                curMax = Math.max(curMax, Math.max(j, m[j]) * (i - j));
            }
            m[i] = curMax;
        }
        return m[length];
    }
    //TODO 假设是至少切一刀所以curMax要为0而且要写Math.max(j, m[j]),如果没有假设，可以写成下面的样子。
    public int maxProduct2(int length) {
        // Write your solution here.
        int[] m = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            int curMax = i;
            for (int j = 1; j <= i; j++) {
                curMax = Math.max(curMax, m[j] * (i - j));
            }
            m[i] = curMax;
        }
        return m[length];
    }
    public static void main(String[] args){
        System.out.print(new MaxProductOfCuttingRope().maxProduct2(2));
    }
}
