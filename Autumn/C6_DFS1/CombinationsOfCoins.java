package Autumn.C6_DFS1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HaoYu on 2017/10/5.
 */
public class CombinationsOfCoins {
    public int combinations(int target, int[] coins) {
        // Write your solution here.
        int[] res = new int[] {0};
        DFS(target, coins, 0, res);
        return res[0];
    }
    private void DFS(int target, int[]coins, int level, int[] res) {
        if (level == coins.length - 1) {
            if (target == 0 || target - coins[level] == 0) {
                res[0]++;//TODO 必须new，否则加的是reference，后面cur还会变
            }
            return;
        }
        for (int i = 0; i <= 1; i++) {
            DFS(target - i  * coins[level], coins, level + 1, res);
        }
    }
    public static void main(String[] args){

        System.out.println(new CombinationsOfCoins().combinations(11, new int[] {8, 5, 3, 2, 1}));
    }
}
