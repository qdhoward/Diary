package NewAutumn.topic.ConnectivityDFSAndBFS1;

public class index {
    public static void main (String[] args) {
        RobotCleaning test1 = new RobotCleaning();
        int[][] maze = new int[][] {
                new int[] {1, 1, 1, 1, 1, 1},
                new int[] {1, 0, 0, 0, 0, 1},
                new int[] {1, 1, 0, 1, 0, 1},
                new int[] {1, 1, 0, 1, 0, 1},
                new int[] {1, 0, 0, 1, 0, 1},
                new int[] {1, 1, 1, 1, 1, 1},
        };
        System.out.println(test1.navieSolution(maze));
    }
}
