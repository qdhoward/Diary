package NewAutumn.mock.saturday.s20190112;

public class DiffOfTwoExtendedString {
    public int countDiff (String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        int pointer1 = 0;
        int pointer2 = 0;
        int count1 = 0;
        int count2 = 0;
        int res = 0;
        while (pointer1 < s1.length() && pointer2 < s2.length()) {
            if (count1 == 0) {
                while (getDigit(s1.charAt(pointer1)) >= 0 && getDigit(s1.charAt(pointer1))<= 9) {
                    count1 = count1 * 10 + getDigit(s1.charAt(pointer1));
                    pointer1++;
                }
            }
            if (count2 == 0) {
                while (getDigit(s2.charAt(pointer2)) >= 0 && getDigit(s2.charAt(pointer2))<= 9) {
                    count2 = count2 * 10 + getDigit(s2.charAt(pointer2));
                    pointer2++;
                }
            }
            if (count1 < count2) {
                if (s1.charAt(pointer1) != s2.charAt(pointer2)) {
                    res += count1;
                }
                //注意要先减再置为0
                count2 -= count1;
                count1 = 0;
                pointer1++;
            } else if (count1 > count2){
                if (s1.charAt(pointer1) != s2.charAt(pointer2)) {
                    res += count2;
                }
                count1 -= count2;
                count2 = 0;
                pointer2++;
            } else {
                if (s1.charAt(pointer1) != s2.charAt(pointer2)) {
                    res += count2;
                }
                count1 = 0;
                count2 = 0;
                pointer1++;
                pointer2++;
            }
        }
        return res;
    }

    private int getDigit(char c) {
        return c - '0';
    }

    public static void main(String[] args) {
        System.out.println(new DiffOfTwoExtendedString().countDiff("0a2c3d", "3a2b0c"));
    }
}
