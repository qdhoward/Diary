package NewAutumn.mock.saturday;
import java.util.*;
        /*
        P1: given a 2d char array as keyboard
        q w e r t y u  i  o p
        a s d f g h  j  k  l  ;
        z x c v b n m ,  . /

        now given a word and a distance, return if the word can be typed out with the given keyboard.
        Note that the distance marks maximum distance we allowed between keystrokes.
        “asd”, distance is 1 ---> true

        “adg”, distance is 1 → false

        input: string, max distance

        P2: Coke Machine has a few buttons. If you pushed a button,
        the machine will output a specific unit of coke.
        Find if I can get the amount of coke in a specific range with unlimited button clicks

        e.g. three buttons: [100, 120], [200, 240], [400, 410]
        if target is [100,110] → false
        [90, 120] → true

        give [150,200] -> false [100,120]
        */
public class s_10_20_2018 {
    public boolean problem1 (String word, int distance) {
        // T: O(keyboard size) S: O(word.length)
        Map<Character, int[]> coordinate = buildLocationMap();
        for (int i = 0; i < word.length() - 1; i++) {
            if (getDistance(word.charAt(i), word.charAt(i + 1), coordinate) > distance) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, int[]> buildLocationMap() {
        char[][] keyboard = new char[3][10];
        keyboard[0] = new char[] {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        keyboard[1] = new char[] {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', ';'};
        keyboard[2] = new char[] {'z', 'x', 'c', 'v', 'b', 'n', 'm', ',', '.', '/'};
        Map<Character, int[]> coordinate = new HashMap<>();
        for (int i = 0; i < keyboard.length; i++) {
            for (int j = 0; j < keyboard[0].length; j++) {
                coordinate.put(keyboard[i][j], new int[] {i ,j});
            }
        }
        return coordinate;
    }

    private int getDistance(char a, char b, Map<Character, int[]> coordinate) {
        int[] coordinate_a = coordinate.get(a);
        int[] coordinate_b = coordinate.get(b);
        return Math.abs(coordinate_a[0] - coordinate_b[0]) + Math.abs(coordinate_a[1] - coordinate_b[1]);
    }

    public boolean problem2_dfs (int min, int max, int[] target, int[][] buttons) {
        // T: O(3^(target(max)/button_min)) S: O(target(max)/button_min)
        if (min >= target[0]) {
            return max <= target[1];
        }
        for (int[] button : buttons) {
            if (problem2_dfs(min + button[0], max + button[1], target, buttons)) {
                return true;
            }
        }
        return false;
    }

    public boolean problem2_dp (int[] target, int[][] buttons) {
        //dp[i] represents the lowest upperbound it can reach where i is the lowerbound.
        int[] dp = new int[target[1] + 1];
        //base case
        dp[buttons[0][0]] = buttons[0][1];
        dp[buttons[1][0]] = buttons[1][1];
        dp[buttons[2][0]] = buttons[2][1];

        for (int i = 0; i <= target[1]; i++) {
            int a = i - buttons[0][0] > 0 ? 0 : dp[i - buttons[0][0]] + buttons[0][1];
            int b = i - buttons[1][0] > 0 ? 0 : dp[i - buttons[1][0]] + buttons[1][1];
            int c = i - buttons[2][0] > 0 ? 0 : dp[i - buttons[2][0]] + buttons[2][1];
            dp[i] = Math.min(Math.min(a, b), c);
            if (i >= target[0] && dp[i] <= target[1]) {
                return true;
            }
        }
        return false;
    }
}
