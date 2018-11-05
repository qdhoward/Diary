package NewAutumn.topic.Connectivity2;

import java.util.HashMap;
import java.util.Map;

public class NumOfIslandStream {
    private static int[][] directions = new int[][] {
            new int[] {1, 0},
            new int[] {-1, 0},
            new int[] {0, 1},
            new int[] {0, -1},
    };
    private static int number = 0;
    public Map<String, String> parent;
    public Map<String, Integer> rank;
    public NumOfIslandStream() {
        this.parent = new HashMap<>();
        this.rank = new HashMap<>();
    }

    public String find(String s) {
        if (parent.get(s).equals("")) {
            return s;
        }
        parent.put(s, find(parent.get(s)));
        return parent.get(s);
    }

    private void union(String a, String b) {
        if (rank.get(a) > rank.get(b)) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        if (rank.get(a).equals(rank.get(b))) {
            rank.put(b, rank.get(b) + 1);
        }
        parent.put(a, b);
    }

    public int appendCell(int[] cell) {
        String cur = convertToString(cell[0], cell[1]);
        if (!rank.containsKey(cur)) {
            rank.put(cur, 0);
        }
        if (!parent.containsKey(cur)) {
            parent.put(cur, "");
            number++;
        }
        for (int[] direction : directions) {
            String neibor = convertToString(cell[0] + direction[0], cell[1] + direction[1]);
            String parent = this.parent.get(neibor);
            if (parent != null) {
                union(neibor, cur);
                number--;
                break;
            }
        }
        return number;
    }

    private String convertToString(int a, int b) {
        return "" + a + b;
    }
}
