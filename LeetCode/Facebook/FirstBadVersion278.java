package LeetCode.Facebook;

public class FirstBadVersion278 {
    private boolean isBadVersion(int n) {
        return n == Integer.MAX_VALUE;
    }
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            //TODO Why is left < right insted of left + 1 < right
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        System.out.println(new FirstBadVersion278().firstBadVersion(2147483647));
    }
}
