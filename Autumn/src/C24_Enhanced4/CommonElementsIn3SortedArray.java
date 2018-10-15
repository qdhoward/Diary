package C24_Enhanced4;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HaoYu on 2018/1/26.
 */
public class CommonElementsIn3SortedArray {
    public List<Integer> common(int[] a, int[] b, int[] c) {
        // Write your solution here.
        List<Integer> res = new ArrayList<>();
        int aq = 0;
        int bq= 0;
        int cq = 0;
        while (aq < a.length && bq < b.length && cq < c.length) {
            if (a[aq] == b[bq] && b[bq]== c[cq]) {
                res.add(a[aq]);
                aq++;
                bq++;
                cq++;
            } else if (a[aq] <= b[bq] && a[aq]<= c[cq]) {
                aq++;
            } else if (b[bq] <= c[cq] && b[bq] <= a[aq]) {
                //TODO 谁小移谁！但是是<=，不是<!
                bq++;
            } else {
                cq++;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(new CommonElementsIn3SortedArray().common(new int[] {1, 2, 3, 3}, new int[] {2, 3, 4, 4, 5}, new int[] {1, 1, 3, 3}));
    }
}
