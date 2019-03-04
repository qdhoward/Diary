package Fun.Amazon;

public class CandyGame {
    public String candy(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] array = s.toCharArray();
        int slow = -1;
        int fast = 0;
        while (fast < array.length) {
            if (slow == - 1 || slow == 0 || array[slow] != array[fast] || array[slow - 1] != array[slow]) {
                array[++slow] = array[fast++];
            } else {
                while (fast < array.length && array[fast] == array[slow]) {
                    fast++;
                }
                while (slow > 0 && array[slow] == array[slow - 1]) {
                    slow--;
                }
                if (array[slow] == array[slow + 1]) {
                    slow--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= slow; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(
                new CandyGame().candy("AAABBBAAAAAAAA")
        );
        System.out.println(
                new CandyGame().candy("AA")
        );
        System.out.println(
                new CandyGame().candy("AABBBACCCACCC")
        );
    }
}
