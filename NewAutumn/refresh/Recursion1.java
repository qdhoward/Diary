package NewAutumn.refresh;

public class Recursion1 {
    public long fibonacci(int K) {
        // Write your solution here T 2^n S n
        if (K <= 0) {
            return 0;
        }
        long a = 0;
        long b = 1;
        while (K > 1) {
            long tmp = a + b;
            //TODO a b tmp 每次向右移动一位，所以顺序要是a = b, b = tmp, 不能反过来
            a = b;
            b = tmp;
            K--;
        }
        return b;
    }

    public long power(int a, int b) {
        // Write your solution here T logb S logb
        if (a == 1 || b == 0) {
            return 0;
        }
        if (a == 0) {
            return 0;
        }
        long half = power(a, b/2);
        return b % 2 == 0 ? half * half : half * half * a;
    }

    public long power2(int a, int b) {
        // Write your solution here
        if (a == 1 || b == 0) {
            return 1;
        }
        if (a == 0) {
            return 0;
        }
        long result = 1;
        for(int i = 1; i <= b; i++) {
            result *= a;
        }
        return result;
    }

}
