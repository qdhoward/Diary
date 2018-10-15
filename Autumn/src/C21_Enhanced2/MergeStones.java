package C21_Enhanced2;

import C12_DP1.MaxProductOfCuttingRope;

/**
 * Created by HaoYu on 2017/11/28.
 */
public class MergeStones {
    public int minCost(int[] stones) {
        // Write your solution here.
        int length = stones.length;
        int[][] costs = new int[length][length];
        int[][] weight = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (i == j) {
                    costs[i][j] = 0;
                    weight[i][j] = stones[i];
                } else {
                    costs[i][j] = Integer.MAX_VALUE;
                    weight[i][j] = weight[i][j - 1] + stones[j];
                }
                for (int k = i; k + 1 <= j; k++) {
                    costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k + 1][j] + weight[i][j]);
                }
            }
        }
        return costs[0][length - 1];
    }
    public static void main(String[] args){
        System.out.print(new MergeStones().minCost(new int[] {4, 3, 3, 4}));
    }
}
