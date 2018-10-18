package C11_BitOperation;

/**
 * Created by HaoYu on 2017/10/30.
 */
public class HexadecimalRepresentation {
    public String hex(int number) {
        // Write your solution here.
        String prefix = "0x";
        if (number == 0) {
            return "0x0";
        }
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            int m = number % 16;
            if(m < 10) {
                sb.append((char)('0' + m));
            } else {
                sb.append((char)('A' + (m - 10)));
            }
            number = number / 16;
        }
        return prefix + sb.reverse().toString();
    }
    public static void main(String[] args){
        System.out.print(new HexadecimalRepresentation().hex(26));
    }
}
