package NewAutumn.mock.saturday.s20190119;

public class ShortestSubarraywithSumatLeastK {
    public int shortestSubarray(int[] A, int K) {
        // All A[i] is positive
        // Sliding window
        int slow = 0;
        int fast = 0;
        int sum = 0;
        int res = A.length + 1;
        while (fast < A.length) {
            if (sum < K) {
                sum += A[fast];
                fast++;
                while (sum >= K) {
                    res = Math.min(res, fast - slow);
                    sum -= A[slow];
                    slow++;
                }
            }
        }
        return res == A.length + 1 ? 0 : res;
    }
    public static void main(String[] args) {
        System.out.println(new ShortestSubarraywithSumatLeastK().shortestSubarray(new int[] {2,3,1,2,4,3}, 100));
    }
}
