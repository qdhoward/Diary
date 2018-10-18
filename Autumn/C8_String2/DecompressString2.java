package C8_String2;

/**
 * Created by HaoYu on 2017/10/19.
 */
public class DecompressString2 {
    public String decompress(String input) {
        // Write your solution here.
        if (input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        return decodeLong(array, decodeShort(array));
    }
    private int decodeShort(char[] array) {
        int end = 0;
        for (int i = 0; i < array.length; i+=2) {
            int digit = getDigit(array[i + 1]);
            if (digit >= 0 && digit <= 2) {
                for (int j = 0; j < digit; j++) {
                    array[end++] = array[i];
                }
            } else {
                array[end++] = array[i];
                array[end++] = array[i+1];
            }
        }
        return end;
    }
    private String decodeLong(char[] array, int length) {
        int newLength = length;
        for (int i = 0; i < length; i ++) {
            int digit = getDigit(array[i]);
            if (digit >=2 && digit <= 9) {
                newLength += digit - 2;
                //TODO 只加上扩充的长度就可以了！-2！
            }
        }
        char[] res = new char[newLength];
        int end = newLength - 1;
        for (int i = length - 1; i >= 0; i--) {
            int digit = getDigit(array[i]);
            if (digit >= 2 && digit <= 9) {
                i--;//TODO 找到数字前面的字母！
                for (int j = 0; j < digit; j++) {
                    res[end--] = array[i];
                }
            } else {
                res[end--] = array[i];
                //TODO 第二遍遍历的时候就没有两个一组的性质了！
            }
        }
        return new String(res);
    }
    private int getDigit (char input) {
        return input - '0';
    }

    public static void main(String[] args){
        System.out.print(new DecompressString2().decompress("a1c0b2c4"));
    }
}
