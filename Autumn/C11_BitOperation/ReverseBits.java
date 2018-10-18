package C11_BitOperation;

/**
 * Created by HaoYu on 2017/10/30.
 */
public class ReverseBits {
    public int reverseint(int num) {
        for (int i = 0; i < 16; i++) {
            int right = (num >> i) & 1;
            int left = (num >> 31 - i) & 1;
            if (right != left) {
                num ^= (1 << i);
                num ^= (1 << (31 - i));
            }
        }
        return num;
    }
    public static void main(String[] args){
        System.out.print(new ReverseBits().reverseint(1));
    }
}
