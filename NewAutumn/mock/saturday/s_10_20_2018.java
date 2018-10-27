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
}
