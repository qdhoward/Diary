package LeetCode;

public class PreimageZeroesFunction793 {
    public int preimageSizeFZF(int K) {

    }
    private int countEndZero(int num) {
        if (num == 0) {
            return 0;
        }
        return num / 5 + countEndZero(num / 5);
    }
}
