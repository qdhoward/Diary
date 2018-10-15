package C18_Enhanced1;

import java.util.Arrays;

/**
 * Created by HaoYu on 2017/11/6.
 */
public class Move0sToTheEnd2 {
    //TODO quiclsort可以做，但是无法保持stable，要想stable还得用快慢指针
    public int[] moveZero(int[] array) {
        // Write your solution here.
        if (array.length <= 1) {
            return array;
        }
        int s = 0;
        for (int f = 0; f < array.length; f++) {
            if (array[f] != 0) {
                array[s++] = array[f];
            }
        }
        while (s < array.length) {
            array[s++] = 0;
        }
        return array;
    }
}
