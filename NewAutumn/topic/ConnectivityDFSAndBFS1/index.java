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
        int[][] maze2 = new int[][] {
                new int[] {1, 1, 1, 1, 1, 1},
                new int[] {1, 0, 0, 0, 0, 1},
                new int[] {1, 0, 0, 1, 0, 1},
                new int[] {1, 0, 0, 1, 0, 1},
                new int[] {1, 0, 0, 1, 0, 1},
                new int[] {1, 1, 1, 1, 1, 1},
        };
        System.out.println(test1.navieSolution(maze));
        System.out.println(test1.navieSolution(maze2));

        GoIsDead test2 = new GoIsDead();
        int[][] go = new int[][] {
                new int[] {1, 1, 1, 1, 1, 1},
                new int[] {1, 0, 1, 0, 0, 1},
                new int[] {1, -1, 1, 1, 0, 1},
                new int[] {1, 1, 0, 1, 0, 1},
                new int[] {1, 0, 0, 1, 0, 1},
                new int[] {1, 1, 1, 1, 1, 1},
        };
        System.out.println(test2.isDeadBfs(go, 1, 1));
        System.out.println(test2.isDeadBfs(go, 1, 3));
        System.out.println(test2.isDeadDfS(go, 1, 1));
        System.out.println(test2.isDeadDfS(go, 1, 3));

        ContinentalDivider test3 = new ContinentalDivider();
        int[][] matrix = new int[][] {
                new int[] {1, 1, 2, 3, 5},
                new int[] {1, 2, 3, 4, 4},
                new int[] {2, 4, 5, 3, 1},
                new int[] {6, 7, 1, 4, 5},
                new int[] {5, 1, 1, 2, 4},
        };
        System.out.println(test3.solution(matrix));
    }
}
