package C13_DP2;

/**
 * Created by HaoYu on 2017/10/30.
 */
public class ArrayHopper2 {
    public int minJump(int[] array) {
        // Write your solution here.
        if (array.length == 1) {
            return 0;
        }
        int[] res = new int[array.length];
        res[array.length - 1] = 0;
        for (int i = array.length - 2; i >= 0; i--) {
            res[i] = -1;
            //res[i]代表从i到结尾的最小步数
            //TODO 还是从右向左看但是用负数代表无法到达
            if (i + array[i] >= array.length - 1) {
                res[i] = 1;
            } else {
                int cur = array.length;
                for (int j = 1; j <= array[i]; j++) {
                    if (res[i + j] != -1) {//只有在可以到达的时候才有更新操作
                        cur = Math.min(cur, res[i + j]);
                        res[i] = cur + 1;
                    }
                }
            }
        }
        return res[0];
    }

    public int minJump2(int[] array) {
        // Write your solution here.
        int[] res = new int[array.length];
        res[0] = 0;
        //TODO m[i]代表从0到达i的最小步数
        for (int i = 1; i < array.length; i++){
            res[i] = -1;//初始状态
            for(int j = 0; j < i; j++) {
                if (res[j] != -1 && j + array[j] >= i) {
                    if(res[i] == -1 || res[i] > res[j] + 1) {
                        res[i] = res[j] + 1;
                        //TODO 因为初始值是-1所以不能直接用Math.min
                    }
                }
            }
        }
        return res[array.length - 1];
    }

    public int minJump3(int[] array) {
        // Write your solution here.
        int res = 0;
        int maxReach = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > maxReach) {
                return -1;
            }
            //TODO Greedy的方法因为没有保存每步的最小值，所以必须始终检测结果，一旦能到达终点，立刻跳出
            if (maxReach >= array.length - 1) {
                return res;
            }
            if (maxReach < i + array[i]) {
                maxReach = i + array[i];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        System.out.print(new ArrayHopper2().minJump3(new int[] {4,2,1,2,0,0}));
    }
}
