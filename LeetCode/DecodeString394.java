package LeetCode;

public class DecodeString394 {
    // Time O(n^2) Space O(n)
    public String decodeString(String s) {
        return unitDecoder(s, 0, s.length() - 1);
    }

    private String unitDecoder(String s, int start, int end) {
        int number = 0;
        StringBuilder cur = new StringBuilder();
        for (int i = start; i <= end; i++) {
            int curNumber = getNumber(s.charAt(i));
            int nextStart = i;
            int nextEnd = 0;
            if (curNumber >= 0 && curNumber <= 9) {
                number = 10 * number + curNumber;
            } else if (s.charAt(i) == '[') {
                int count = 1;
                for (i = nextStart + 1; i <= end; i++) {
                    if (s.charAt(i) == '[') {
                        count++;
                    }
                    if (s.charAt(i) == ']') {
                        count--;
                    }
                    if (count == 0) {
                        nextEnd = i;
                        break;
                    }
                }
                String res = unitDecoder(s,nextStart + 1, nextEnd - 1);
                for (int k = 0; k < number; k++) {
                    cur.append(res);
                }
                number = 0;
            } else {
                cur.append(s.charAt(i));
            }
        }
        return cur.toString();
    }

    private int getNumber (char input) {
        return input - '0';
    }
}
