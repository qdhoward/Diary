package C11_BitOperation;

/**
 * Created by HaoYu on 2017/10/30.
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int number) {
        // Write your solution here.
        if(number < 1) {
            return false;
        }
        while (number % 2 == 0) {
            number = number / 2;
        }
        return number == 1;
    }
    public boolean isPowerOfTwo2(int number) {
        // Write your solution here.
        if(number < 1) {
            return false;
        }
        return (number & (number - 1)) == 0;
        //TODO 注意优先级，不能写成number & (number - 1) == 0
    }
}
