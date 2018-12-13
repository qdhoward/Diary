package Fun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MergeTwoList {
    public List<Integer> mergeArr(int[] a1, int[] a2){
        int len1 = a1.length, len2 = a2.length;
        if (len1 > len2) {
            mergeArr(a2, a1);
        }
        List<Integer> res = new ArrayList<>();
        if (a1 == null && a2 == null) {
            return res;
        }
        else if (a1 == null) {
            res = new ArrayList(Arrays.asList(a2));
            return res;
        }
        else if(a2 == null) {
            res = new ArrayList(Arrays.asList(a1));
            return res;
        }

        //key: number in two of the list;
        //val : freqent of this number in two of the list
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: a1) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        for(int num: a2) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int i = 0;
        int j = 0;
        while(i < len1) {
            if (map.get(a1[i]) == null) {
                i++;
            }
            if (map.get(a1[i]) == 1) {
                res.add(a1[i]);
                i++;
            }
            else if (map.get(a1[i]) == 2){
                while(j < len2) {
                    while (a2[j] != a1[i]) {
                        res.add(a2[j]);
                        map.remove(a2[j]);
                        j++;
                    }
                    j++;
                    break;
                }

                res.add(a1[i]);
                map.remove(a1[i]);
                i++;
            }
        }
        for(int idx = j; idx < len2; idx++) {
            res.add(a2[idx]);
        }
        return res;
    }
    public static void main(String[] args) {
        MergeTwoList test = new MergeTwoList();
        int[] a1 = {1,2,3,4,5,6,7,8,9};
        int[] a2 = {10,2,12,13,5,15,8,20};
        List<Integer> res = test.mergeArr(a1, a2);
        System.out.print(res);//[1, 10, 2, 3, 4, 12, 13, 5, 6, 7, 15, 8, 9, 20]
        int[] a3 = {1,2,3,4,5,6,7,8,9};
        int[] a4 = {10,8,2,12,13,5,15,20};
        List<Integer> res1 = test.mergeArr(a3, a4);//[1, 10, 8, 2, 3, 4, 12, 13, 5, 6, 7, 9, 15, 20]
        System.out.print(res1);
    }
}
