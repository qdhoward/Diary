package NewAutumn.topic.DP;

public class index {
    public static void main(String[] args) {
        GameTheory test = new GameTheory();
        System.out.println(test.greedyStrategy(new int[] {5, 2, 1, 100, 3}));
        System.out.println(test.optimizeStrategy(new int[] {5, 2, 1, 100, 3}));
    }
}
