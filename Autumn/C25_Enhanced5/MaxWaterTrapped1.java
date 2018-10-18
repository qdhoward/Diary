package C25_Enhanced5;

/**
 * Created by HaoYu on 2018/2/8.
 */
public class MaxWaterTrapped1 {
    public int maxTrapped(int[] array) {
        // Write your solution here.
        int lmax = array[0];
        int rmax = array[array.length - 1];
        int left = 0;
        int right = array.length - 1;
        int res = 0;
        while (left <= right) {
            lmax = Math.max(lmax, array[left]);
            rmax = Math.max(rmax, array[right]);
            if (lmax < rmax) {
                res += Math.max(0, lmax - array[left]);
                left++;
            } else {
                res += Math.max(0, rmax - array[right]);
                right--;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(new MaxWaterTrapped1().maxTrapped(new int[] { 5,3,2,1,4,6 }));
    }
}
