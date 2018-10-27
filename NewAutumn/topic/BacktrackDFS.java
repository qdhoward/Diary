package NewAutumn.topic;

import java.util.ArrayList;
import java.util.List;

public class BacktrackDFS {
    public static void main (String[] args) {
        BacktrackDFS test = new BacktrackDFS();
        System.out.println(test.allFactor(12));
    }
    public List<Integer> binaryNumWithKOne(int k) {
        return new ArrayList<>();
    }
    public List<List<Integer>> allFactor(int n) {
        //Time O(n^2) Space O(n)
        List<Integer> curResult = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        allFactorHelper(n, n, curResult, res);
        return res;
    }

    public void allFactorHelper(int n, int lastFactor, List<Integer> curResult, List<List<Integer>> res) {
        if (n == 1) {
            res.add(new ArrayList<>(curResult));//Need to make a copy of the curResult!
        }
        for (int i = 2; i <= Math.min(lastFactor, n); i++) {
            if (n % i == 0) {
                curResult.add(i);
                allFactorHelper(n / i, i, curResult, res);
                curResult.remove(curResult.size() - 1);
            }
        }
    }

    public List<List<Integer>> allSum(int n) {
        //Time O(n^2) Space O(n)
        List<Integer> curResult = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        allSumHelper(n, n, curResult, res);
        return res;
    }

    public void allSumHelper(int n, int lastNum, List<Integer> curResult, List<List<Integer>> res){
        
    }
}
