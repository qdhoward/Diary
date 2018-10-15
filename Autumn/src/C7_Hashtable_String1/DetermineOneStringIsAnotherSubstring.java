package C7_Hashtable_String1;

/**
 * Created by HaoYu on 2017/10/9.
 */
public class DetermineOneStringIsAnotherSubstring {//TODO 这是RabinCarp Method
    public int strstr(String large, String small) {
        // write your solution here
        if (small.length() == 0) {
            return 0;
        }
        if (small.length() > large.length()) {
            return -1;
        }
        int largePrime = 101;
        int prime = 31;
        int seed = 1;
        int targetHash = small.charAt(0) % largePrime;
        int hash = 0;
        for (int i = 1; i < small.length(); i++) {
            seed = moduleHash(seed, 0, largePrime, prime);
            targetHash = moduleHash(targetHash, small.charAt(i), largePrime, prime);
        }
        for (int i = 0; i < small.length(); i++) {
            hash = moduleHash(hash, large.charAt(i), largePrime, prime);
        }
        if (hash == targetHash && equals(small, large, 0)) {
            //TODO large开头就匹配的情况需要单独考虑！
            return 0;
        }
        for (int i = 1; i <= large.length() - small.length(); i++) {
            hash = nonNegative(hash - seed * large.charAt(i - 1) % largePrime, largePrime);
            hash = moduleHash(hash, large.charAt(i + small.length() - 1), largePrime, prime);
            if (hash == targetHash && equals(small, large, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean equals (String small, String large, int start) {
        for (int i = 0; i < small.length(); i++) {
            if (small.charAt(i) != large.charAt(i + start)) {
                return false;
            }
        }
        return true;
    }
    private int moduleHash (int hash, int addition, int largePrime, int prime) {
        return ((hash * prime) % largePrime + addition) % largePrime;
    }
    private int nonNegative (int hash, int largePrime) {
        if (hash < 0) {
            hash += largePrime;
            //TODO 因为是取余运算，所以加一次largePrime后一定大于0
        }
        return hash;
    }
    public static void main(String[] args) {
        System.out.println(new DetermineOneStringIsAnotherSubstring().strstr("bcabc", "ab"));
    }
}
