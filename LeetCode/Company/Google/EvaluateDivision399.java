package LeetCode.Company.Google;

import java.util.HashMap;
import java.util.Map;

public class EvaluateDivision399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res = new double[queries.length];
        Map<String, String> parent = new HashMap<>();
        Map<String, Double> value = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            union(parent, values, equations, value, i);
        }
        for (int i = 0; i < queries.length; i++) {
            if (!parent.containsKey(queries[i][0]) || !parent.containsKey(queries[i][1])) {
                res[i] = -1.0;
                continue;
            }
            String r1 = find(parent, value, queries[i][0]);
            String r2 = find(parent, value, queries[i][1]);
            if (!r1.equals(r2)) {
                res[i] = -1.0;
                continue;
            }
            res[i] = (double) value.get(queries[i][0]) / value.get(queries[i][1]);
        }
        return res;
    }

    private String find(Map<String, String> parent, Map<String, Double> value, String s) {
        if (!parent.containsKey(s)) {
            parent.put(s, s);
            value.put(s, 1.0);
            return s;
        }
        if (parent.get(s).equals(s)) {
            return s;
        }
        String lastParent = parent.get(s);
        String rootParent = find(parent, value, lastParent);
        parent.put(s, rootParent);
        value.put(s, value.get(s) * value.get(lastParent));
        return rootParent;
    }

    private void union(Map<String, String> parent, double[] values, String[][] equations, Map<String, Double> value, int index) {
        String r1 = find(parent, value, equations[index][0]);
        String r2 = find(parent, value, equations[index][1]);
        parent.put(r1, r2);
        value.put(r1, value.get(equations[index][1]) * values[index] / value.get(equations[index][0]));
    }
}
