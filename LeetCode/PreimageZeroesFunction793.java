package LeetCode;

public class PreimageZeroesFunction793 {
    public int preimageSizeFZF(int K) {
        long left = 0, right = 5 * (long) K + 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = countEndZero(mid);
            if (count == K) return 5;
            else if (count < K) left = mid + 1;
            else right = mid - 1;
        }
        return 0;
    }
    private long countEndZero(long num) {
        if (num == 0) {
            return 0;
        }
        return num / 5 + countEndZero(num / 5);
    }
}
