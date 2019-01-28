package NewAutumn.mock.saturday.s20190126;

public class WhoWinFirst {
    public boolean firstWin(int T, int W) {
        //Assuming Sum(1,2...T) >= W
        boolean[] used = new boolean[T + 1];
        int[] memo = new int[W + 1];
        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (!helper(used, W - i, memo)) {
                    used[i] = false;
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    private boolean helper (boolean[] used, int W, int[] memo) {
        if (W <= 0) {
            return false;
        }
        if (memo[W] != 0) {
            return memo[W] == 1;
        }
        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                if (!helper(used, W - i, memo)) {
                    memo[W] = 1;//memo为1，表示剩余w的时候先手能赢
                    used[i] = false;
                    return true;
                }
                used[i] = false;
            }
        }
        memo[W] = -1;//memo为-1，表示剩余w的时候先手不能赢
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WhoWinFirst().firstWin(5, 6));
    }
}
