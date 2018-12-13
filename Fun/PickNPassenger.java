package Fun;

import java.util.ArrayList;
import java.util.List;

public class PickNPassenger {
    public List<List<Integer>> pickup(char[][] matrix, int n) {
        int minStep = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'R') {
                    List<List<Integer>> path = new ArrayList<>();
                    if (getAllRider(i, j, matrix, n, path) < minStep) {
                        res = path;
                    }
                }
            }
        }
        return res;
    }

    private int getAllRider(int i, int j, char[][] matrix, int n, List<List<Integer>> path){
        return 0;
    }
}
