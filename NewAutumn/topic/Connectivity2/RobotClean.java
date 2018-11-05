package NewAutumn.topic.Connectivity2;

import java.util.HashSet;
import java.util.Set;

public class RobotClean {
    class Point {
        public int x;
        public int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof Point)) {
                return false;
            }
            Point another = (Point) object;
            return this.x == another.x && this.y == another.y;
        }
        @Override
        public int hashCode() {
            return x * 31 + y;
        }
    }

    class Direction{
        int[][] directions = {
                new int[] {1, 0},
                new int[] {-1, 0},
                new int[] {0, 1},
                new int[] {0, -1},
        };
        public int xOffset;
        public int yOffset;
        public int currentDirection;
        public Direction() {
            this.currentDirection = 0;
            this.xOffset = 1;
            this.yOffset = 0;
        }
        public void turnLeft() {
            this.currentDirection += 1;
            int[] direction = directions[this.currentDirection % 4];
            this.xOffset = direction[0];
            this.yOffset = direction[1];
        }
    }

    interface Robot {
        boolean move();
        void clean();
        void turnLeft();
    }

    public void startClean(Robot robot) {
        Set<Point> visited = new HashSet<>();
        Direction directions = new Direction();
        dfs(robot, directions, new Point(1, 1), visited);
    }

    public void dfs(Robot robot, Direction directions, Point point, Set<Point> visited) {
        if (visited.contains(point)) {
            backtrack(robot);
            return;
        }
        visited.add(point);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                point.x += directions.xOffset;
                point.y += directions.yOffset;
                dfs(robot, directions, point, visited);
                backtrack(robot);
                point.x -= directions.xOffset;
                point.y -= directions.yOffset;
            }
            directions.turnLeft();
            robot.turnLeft();
            //一共转了四次，最后一次又转回i=0的时候的方向了
        }

    }

    private void backtrack(Robot robot) {
        //Go back to the previous position and maintain previous direction.
        turnAround(robot);
        robot.move();
        turnAround(robot);
    }

    private void turnAround(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
    }
}
