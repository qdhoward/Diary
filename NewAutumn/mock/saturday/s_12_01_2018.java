package NewAutumn.mock.saturday;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.*;

public class s_12_01_2018 {
    public boolean pickCoinGame(int[] array) {
        boolean[] dp = new boolean[array.length];
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= i) {
                if (dp[i - 1]) {
                    dp[i] = (array[i] / i) % 2 == 0;
                } else {
                    dp[i] = (array[i] / i) % 2 != 0;
                }
            }
        }
        return dp[array.length - 1];
    }

    public boolean pickCoinGame2(int[] array) {
        return helper(array);
    }

    private boolean helper(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= i) {
                array[i] -= i;
                if (!helper(array)) {
                    return true;
                }
                array[i] += i;
            }
        }
        return false;
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.equals("")) {
            res.add("");
            return res;
        }
        Set<String> visited = new HashSet<>();
        helper(s, 0, 0, res, new char[] {'(', ')'}, visited);
        helper(new StringBuilder(s).reverse().toString(), 0, 0, res, new char[] {')', '('}, visited);
        if (res.size() == 0) {
            res.add("");
        }
        return res;
    }
    private void helper (String s, int start, int last, List<String> res, char[] tool, Set<String> visited) {
        int count = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == tool[0]) {
                count++;
            } else if (s.charAt(i) == tool[1]) {
                count--;
            }   //TODO (()
            if (count < 0) {
                for (int j = last; j <= i; j++) {
                    if (s.charAt(j) == tool[1] && (j == 0 || s.charAt(j - 1) != tool[1])) {
                        String tmp = s.substring(0, j) + s.substring(j + 1, s.length());
                        helper(tmp, i, j, res, tool, visited);
                    }
                }
                return;
            }
        }
        if (isValid(s) && visited.add(s)) {
            res.add(s);
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }



    public int subarraySumEqualK(int[] array, int target) {
        int prefixSum = 0;
        Map<Integer, Integer> visited = new HashMap<>();
        visited.put(0, 1);//初始状态
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            prefixSum += array[i];
            int sum = prefixSum - target;
            if (visited.containsKey(sum)) {
                count += visited.get(sum);
            }
            visited.put(prefixSum, visited.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    public List<Integer> travelPlan(int[] array) {
        int[] dp = new int[array.length];
        int[] backIndex = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            dp[i] = array[i] <= 200 ? (200 - array[i]) * (200 - array[i]) : Integer.MAX_VALUE;
            backIndex[i] = -1;
            for (int j = 0; j < i; j++) {
                if (array[j] - 200 > array[i]) break;//TODO 如果上一点的距离大于200，肯定走不到了，直接跳出
                int curpenalty = dp[j] + (200 - array[i] + dp[j]) * (200 - array[i] + dp[j]);
                if (dp[i] > curpenalty) {
                    dp[i] = curpenalty;
                    backIndex[i] = j;
                }
            }
            if (dp[i] == Integer.MAX_VALUE) {
                //TODO 跳出后发现还没有
                return new ArrayList<>();
            }
        }
        int nextStep = backIndex[array.length - 1];
        List<Integer> res = new ArrayList<>();
        res.add(array.length - 1);
        while (nextStep != -1) {
            res.add(backIndex[array.length - 1]);
            nextStep = backIndex[nextStep];
        }
        return res;
    }

    public static void main(String[] args) {
        s_12_01_2018 test = new s_12_01_2018();
        System.out.println(test.pickCoinGame(new int[] {1, 2, 3}));
        System.out.println(test.removeInvalidParentheses("(()"));
        System.out.println(test.removeInvalidParentheses("()())()"));
        System.out.println(test.subarraySumEqualK(new int[] {1, 1, 1}, 2));
        System.out.println(test.travelPlan(new int[] {50, 150, 250, 350}));
    }
}
