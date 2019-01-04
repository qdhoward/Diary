package LeetCode.Topic.String;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion6 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder[] res = new StringBuilder[numRows];
        int row = 0;
        boolean up = false;
        for (int i = 0; i < s.length(); i++) {
            if (res[row] == null) {
                res[row] = new StringBuilder();
            }
            res[row].append(s.charAt(i));
            if (row == numRows - 1 || row == 0) {
                up = !up;
            }
            if (up && row < res.length) {
                row++;
            } else if (!up && row >= 0){
                row--;
            }
            //TODO row < res.length 和 row >= 0 是为了handle 行数为1 ，其实可以放在开头base case里面
        }
        StringBuilder all = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (res[i] != null) {
                all.append(res[i]);
            }
        }
        return all.toString();
    }
}
