package NewAutumn.mock.saturday.s20190126;

import java.util.HashMap;
import java.util.Map;

public class DropEgg {
    public int superEggDrop(int K, int N) {
        Map<Integer, Integer> dp = new HashMap<>();
        return helper(N, K, dp);
    }

    private int helper(int floor, int egg, Map<Integer, Integer> dp) {
        //base case
        if (floor == 0) {
            return 0;
        }
        if (egg == 1) {
            return floor;
        }

        //Induction rule
        if (!dp.containsKey(floor * 100 + egg)) {
            int left = 1;
            int right = floor;
            while (left + 1 <  right) {
                int mid = (left + right) / 2;
                //mid层碎了
                int res1 = helper(mid - 1, egg - 1, dp);
                //没碎
                int res2 = helper(floor - mid, egg, dp);
                if (res1 < res2) {
                    left = mid;
                } else if (res1 > res2) {
                    right = mid;
                } else {
                    left = right = mid;
                }
            }
            //别忘了加1啊，每丢一次要加1啊！！！！！
            int res = 1 + Math.min(Math.max(helper(left - 1, egg - 1, dp), helper(floor - left, egg, dp)),
                    Math.max(helper(right - 1, egg - 1, dp), helper(floor - right, egg, dp)));
            dp.put(floor * 100 + egg, res);
        }
        return dp.get(floor * 100 + egg);
    }

    public static void main(String[] args) {
        System.out.println(new DropEgg().superEggDrop(2, 10));
    }
}
