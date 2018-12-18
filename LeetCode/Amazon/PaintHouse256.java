package LeetCode.Amazon;

public class PaintHouse256 {
    public int minCost(int[][] costs) {
        if (costs == null ||  costs.length == 0) {
            return 0;
        }
        int[][] newCosts = new int[costs.length][costs[0].length];
        for (int i = 0; i < costs[0].length; i++) {
            newCosts[0][i] = costs[0][i];
        }
        for (int house = 1; house < costs.length; house++) {
            for (int color = 0; color < costs[0].length; color++) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < costs[0].length; i++) {
                    if (i != color) {
                        min = Math.min(min, newCosts[house - 1][i]);
                    }
                }
                newCosts[house][color] = min + costs[house][color];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            res = Math.min(res, newCosts[costs.length - 1][i]);
        }
        return res;
    }
}
