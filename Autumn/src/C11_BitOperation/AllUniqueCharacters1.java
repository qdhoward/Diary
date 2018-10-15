package C11_BitOperation;

/**
 * Created by HaoYu on 2017/10/30.
 */
public class AllUniqueCharacters1 {
    public boolean allUnique(String word) {
        // write your solution here
        if(word == null || word.length() <= 1) {
            return false;
        }
        char[] array = word.toCharArray();
        int[] alphabet = new int[8];
        for (char c : array) {
            int bitindex = c;
            int row = bitindex / 32;
            int col = bitindex % 32;
            if ((alphabet[row] & (1 << col)) != 0) {
                return false;
            } else {
                alphabet[row] = alphabet[row] | (1 << col);
            }
        }
        return true;
    }
}
