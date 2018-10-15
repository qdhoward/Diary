package C25_Enhanced5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by HaoYu on 2018/1/30.
 */
public class LargestProductOfLength {
    public int largestProduct(String[] dict) {
        // Write your solution here.
        HashMap<String, Integer> bitmask = bitmask(dict);
        int length = 0;
        Arrays.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < dict.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dict[i].length() * dict[j].length() < length) {
                    break;
                } else {
                    if ((bitmask.get(dict[i]) & bitmask.get(dict[j])) == 0) {
                        length = dict[i].length() * dict[j].length();
                    }
                }
            }
        }
        return length;
    }
    private HashMap<String, Integer> bitmask(String[] dict) {
        HashMap<String, Integer> res = new HashMap<>();
        for (int i = 0; i < dict.length; i++) {
            int bitmask = 0;
            for (int j = 0; j < dict[i].length(); j++) {
                bitmask |= 1 << (dict[i].charAt(j) - 'a');
            }
            res.put(dict[i], bitmask);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LargestProductOfLength().largestProduct(new String[] {"a","b","c","def","fhiop","lmnu","xyzwu","rstu"}));
    }
}
