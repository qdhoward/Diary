package LeetCode.Company.Amazon;

public class PaintFence276 {
    public int numWays(int n, int k) {
        //if p(n) = p(n - 1), p(n - 1) must not equal to p(n - 2), so p(n) = p(n - 2) * (k - 1)
        //if p(n) != p(n - 1), p (n) = p(n - 1) * k - 1
        if (n == 0 || k == 0 || (k == 1 && n > 3)) {
            return 0;
        }
        int p1 = k;
        int p2 = k * k;
        int p3 = 0;
        if (n == 1) {
            return p1;
        }
        if (n == 2) {
            return p2;
        }
        for (int i = 0; i <= n - 3; i++) {
            p3 = (k - 1) * (p1 + p2);
            p1 = p2;
            p2 = p3;
        }
        return p2;
    }
}
