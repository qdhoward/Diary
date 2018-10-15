package C12_DP1;

/**
 * Created by HaoYu on 2017/10/29.
 */
public class ArrayHopper1 {
    //方法1从右向左DP，2是从左向右DP，3是Greedy
    public boolean canJump(int[] array) {
        // Write your solution here.
        if (array.length == 1) {
            return true;
        }
        boolean[] m = new boolean[array.length];
        //TODO m[i]代表是否可以从i到达终点
        for (int i = array.length - 2; i >= 0; i--){
            if(i + array[i] >= array.length - 1) {
                m[i] = true;
            } else {
                for (int j = 1; j <= array[i]; j++) {
                    if(m[i + j]) {
                        m[i] = true;
                        break;
                    }
                }
            }
        }
        return m[0];
    }
    public boolean canJump2(int[] array) {
        // Write your solution here.
        boolean[] m = new boolean[array.length];
        m[0] = true;//TODO 所以不需要判断Corner case长度为1
        //TODO m[i]代表是否可以从0到达i
        for (int i = 1; i < array.length; i++){
            for(int j = 0; j < i; j++) {
                if (m[j] && j + array[j] >= i) {
                    m[i] = true;
                    break;
                }
            }
        }
        return m[array.length - 1];
    }
    public boolean canJump3(int[] array) {
        // Write your solution here.
        int maxReach = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + array[i]);
        }
        return true;
    }
    public static void main(String[] args){
        System.out.print(new ArrayHopper1().canJump(new int[] {1, 3, 2, 0, 3}));
    }
}
