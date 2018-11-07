package NewAutumn.topic.BestFS;

public class index {
    public static void main(String[] args) {
        MinDayToTarget test = new MinDayToTarget();
        System.out.println(test.minDayToTarget(new int[][] {
                new int[] {0, 9, 9, 9, 9},
                new int[] {1, 9, 9, 9, 9},
                new int[] {2, 9, 2, 3, 2},
                new int[] {2, 3, 4, 9, 3},
                new int[] {1, 9, 9, 9, 1},
        }));
        kthSmallestSumOfTwoSortedArray test2 = new kthSmallestSumOfTwoSortedArray();
        System.out.println(test2.solution(new int[] {1 , 7, 11}, new int[] {2, 4 ,6}, 8));
    }
}
