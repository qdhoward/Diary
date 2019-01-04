package NewAutumn.topic.DP;

public class FlipAtMostOneZero {
    //TODO sliding window
    public int flipZero(int[] array) {
        int slow = 0;
        int fast = 0;
        int zeroCount = 0;
        while (fast < array.length) {
            if (array[fast] == 0) {
                zeroCount++;
                while (zeroCount > 1) {
                    if (array[slow] == 0) {
                        zeroCount--;
                    }slow++;

                }
            }
            fast++;
        }
        return fast - slow + 1;
    }
}
