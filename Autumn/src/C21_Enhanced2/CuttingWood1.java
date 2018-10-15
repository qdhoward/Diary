package C21_Enhanced2;

/**
 * Created by HaoYu on 2017/11/27.
 */
public class CuttingWood1 {
    public int minCost(int[] cuts, int length) {
        // Write your solution here.
        int[] helper = new int[cuts.length + 2];
        for (int i = 0; i < cuts.length; i++) {
            helper[i + 1] = cuts[i];
        }
        helper[0] = 0;
        helper[helper.length - 1] = length;
        int[][] res = new int[helper.length][helper.length];
        for (int i = helper.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < helper.length; j++) {
                if (j == i + 1) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = Integer.MAX_VALUE;
                }
                for (int k = i + 1; k < j; k++) {
                    res[i][j] = Math.min(res[i][j], helper[j] - helper[i] + res[i][k] + res[k][j]);
                }
            }
        }
        return res[0][helper.length - 1];
    }
    public static void main(String[] args){
        System.out.print(new CuttingWood1().minCost(new int[] {2, 4, 7}, 10));
    }
}
