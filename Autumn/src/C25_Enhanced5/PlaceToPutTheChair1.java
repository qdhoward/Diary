package C25_Enhanced5;

import java.util.*;

/**
 * Created by HaoYu on 2018/1/31.
 */
public class PlaceToPutTheChair1 {
    private static final char EQUIP = 'E';
    private static final char OB = 'O';
    static class Pair {
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public List<Integer> putChair(char[][] gym) {
        // Write your solution here
        int m = gym.length;
        int n = gym[0].length;
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gym[i][j] == EQUIP) {
                    if (!addCost(cost, gym, i, j)) {
                        return null;
                    }
                }
            }
        }
        List<Integer> res = null;//TODO corner case1 很重要，如果都是O的话，得返回null, 不能以(0,0)作为初始值。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gym[i][j] != EQUIP && gym[i][j] != OB) {
                    if (res == null) {
                        res = Arrays.asList(i, j);
                    } else if (cost[i][j] < cost[res.get(0)][res.get(1)]) {
                        res.set(0, i);
                        res.set(1, j);
                    }
                }
            }
        }
        return res;
    }

    private List<Pair> getNeis(char[][] gym, Pair cur) {
        int n = gym.length;
        int m = gym[0].length;
        int x = cur.i;
        int y = cur.j;
        List<Pair> res = new ArrayList<>();
        if (x + 1 < m && gym[x + 1][y] != OB) {
            res.add(new Pair(x + 1, y));
        }
        if (x - 1 >= 0 && gym[x - 1][y] != OB) {
            res.add(new Pair(x - 1, y));
        }
        if (y + 1 < n && gym[x][y + 1] != OB) {
            res.add(new Pair(x, y + 1));
        }
        if (y - 1 >= 0 && gym[x][y - 1] != OB) {
            res.add(new Pair(x, y -1));
        }
        return res;
    }

    private boolean addCost(int[][] cost, char[][] gym, int i, int j) {
        boolean[][] visited = new boolean[gym.length][gym[0].length];
        int pathCost = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(i, j));
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                Pair cur = queue.poll();
                List<Pair> neis = getNeis(gym, cur);
                for (Pair nei : neis) {
                    if (!visited[nei.i][nei.j]) {
                        visited[nei.i][nei.j] = true;
                        cost[nei.i][nei.j] += pathCost;
                        queue.offer(nei);
                    }
                }
            }
            pathCost++;
        }
        for (int q = 0; q < gym.length; q++) {
            for (int l = 0; l < gym[0].length; l++) {
                if (!visited[q][l] && gym[q][l] == EQUIP) {//TODO Corner case2 如果一个E到达不了另外一个E那么说明
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(new PlaceToPutTheChair1().putChair(new char[][] { { 'E', 'O', 'C' },

                {  'C', 'E',  'C' },

                {  'C',  'C',  'C' } }));
    }
}
