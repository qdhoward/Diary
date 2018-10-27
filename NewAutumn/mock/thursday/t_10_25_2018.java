package NewAutumn.mock.thursday;

import java.util.ArrayList;
import java.util.List;

public class t_10_25_2018 {
    public static void main(String[] args) {
        //P1
        System.out.println(new t_10_25_2018().isTriagleArray(new int[] {1,2,3}));
        System.out.println(new t_10_25_2018().isTriagleArray(new int[] {3,2,1}));
        System.out.println(new t_10_25_2018().isTriagleArray(new int[] {1,2,3,2,3,2,1}));
        System.out.println(new t_10_25_2018().isTriagleArray(new int[] {1,2,3,7,3,2,1}));
        System.out.println(new t_10_25_2018().findPeak(new int[] {1,4,6,4,2,1}));

        //P2
        System.out.println(new t_10_25_2018().buildArray("112358"));
        System.out.println(new t_10_25_2018().buildArray("12"));
        System.out.println(new t_10_25_2018().buildArray("12333"));

        //P3
        int[][] buttons = new int[][] {
                new int[] {100, 120},
                new int[] {200, 240},
                new int[] {400, 410},
        };
        int[] target1 = {100, 110};
        int[] target2 = {90, 120};

        System.out.println(new t_10_25_2018().getCokePermutation(0, 0, target1, buttons));
        System.out.println(new t_10_25_2018().getCokePermutation(0, 0, target2, buttons));
        System.out.println(new t_10_25_2018().getCokeCombination(0, 0, 0, target1, buttons));
        System.out.println(new t_10_25_2018().getCokeCombination(0, 0, 0, target2, buttons));
        System.out.println(new t_10_25_2018().getCokeDP(target1, buttons));
        System.out.println(new t_10_25_2018().getCokeDP(target2, buttons));

    }
    /*
    P1 1. check whether a array if a triangle array or not
    2. Find the max value in a triangle array
    */
    public boolean isTriagleArray(int[] array) {
        //Time O(n) Space O(1)
        boolean flag = false;
        if (array == null || array.length < 3) {
            return false;
        }
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] <= array[i - 1] && i == 1) {
                return false;
            }
            if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
                if (flag) {
                    return false;
                } else {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public int findPeak(int[] array) {
        //Time O(log(n)) Space O(1)
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
                return array[mid];
            } else if (array[mid - 1] < array[mid] && array[mid] < array[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    /*
    P2 Given a string containing only digits, e.g. "123456579";
    split it and output list of integer F such that  F[i] = F[i-1] + F[i-2];
    for i >= 2;  if not found, output empty list;
    */
    public List<Integer> buildArray(String s){
        //Time O(n^3) Space O(n)
        if (s == null || s.length() <= 2) {
            return new ArrayList<>();
        }

        for (int i = 2; i < s.length(); i++) {
            for (int j = 1; j < i; j++) {
                String firstNum = s.substring(0, j);
                String secondNum = s.substring(j, i);
                List<Integer> res = new ArrayList<>();
                res.add(Integer.parseInt(firstNum));
                res.add(Integer.parseInt(secondNum));
                if (validate(s.substring(i), Integer.parseInt(firstNum),Integer.parseInt(secondNum), res)) {
                    return res;
                }
            }
        }
        return new ArrayList<>();
    }

    private boolean validate(String s, int firstNum, int secondNum, List<Integer> res) {
        if (s.length() == 0) {
            return true;
        }
        String sum = Integer.toString(firstNum + secondNum);
        if (!s.startsWith(sum)) {
            return false;
        }
        res.add(firstNum + secondNum);
        return validate(s.substring(sum.length()), secondNum, firstNum + secondNum, res);
    }

    /*P3: Coke Machine has a few buttons. If you pushed a button,
        the machine will output a specific unit of coke.
        Find if I can get the amount of coke in a specific range with unlimited button clicks

        e.g. three buttons: [100, 120], [200, 240], [400, 410]
        if target is [100,110] → false
        [90, 120] → true

        give [150,200] -> false [100,120]
        */
    public boolean getCokePermutation (int min, int max, int[] target, int[][] buttons) {
        // Time O(3^(target(max)/button_min)) Space O(target(max)/button_min)
        if (min >= target[0]) {
            return max <= target[1];
        }
        for (int[] button : buttons) {
            if (getCokePermutation(min + button[0], max + button[1], target, buttons)) {
                return true;
            }
        }
        return false;
    }

    public boolean getCokeCombination (int min, int max, int index, int[] target, int[][] buttons) {
        // Time O(target(max)/button_min)^3 Space O(3)
        if (index == 3) {
            return min >= target[0] && max <= target[1];
        }
        for (int i = 0; i <= (target[1] / buttons[index][1]); i++) {
            if (getCokeCombination(min + i * buttons[index][0], max + i * buttons[index][1], index + 1, target, buttons)){
                return true;
            }
        }
        return false;
    }

    public boolean getCokeDP(int[] target, int[][] buttons) {
        //dp[i] represents the lowest upperbound it can reach where i is the lowerbound.
        //Time O(button_max_right_range) Space O(button_max_right_range)
        int max = Math.max(Math.max(buttons[0][1], buttons[1][1]), buttons[2][1]);
        int[] dp = new int[max + 1];
        //base case
        dp[buttons[0][0]] = buttons[0][1];
        dp[buttons[1][0]] = buttons[1][1];
        dp[buttons[2][0]] = buttons[2][1];

        for (int i = 0; i <= max; i++) {
            int a = i - buttons[0][0] < 0 ? Integer.MAX_VALUE : dp[i - buttons[0][0]] + buttons[0][1];
            int b = i - buttons[1][0] < 0 ? Integer.MAX_VALUE : dp[i - buttons[1][0]] + buttons[1][1];
            int c = i - buttons[2][0] < 0 ? Integer.MAX_VALUE : dp[i - buttons[2][0]] + buttons[2][1];
            if (a != Integer.MAX_VALUE || b != Integer.MAX_VALUE || c != Integer.MAX_VALUE) {
                dp[i] = Math.min(Math.min(a, b), c);
            }
            if (i >= target[0] && dp[i] <= target[1]) {
                return true;
            }
        }
        return false;
    }
}
