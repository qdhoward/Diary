package Fun.OOD;

import java.util.*;

public class RPG {
    private Item[][] gird;
    private static int[][] directions = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    abstract class Item {
        int value;
    }

    private class Backpack {
        Item[] array;
        Backpack(int size) {
            array = new Item[size];
        }

        public void add(Item i) throws Exception {
            for (int j = 0; j < array.length; j++) {
                if (array[j] == null) {
                    array[j] = i;
                }
            }
            throw new Exception("Backpack is full");
        }

        public boolean remove(Item i) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] == i) {
                    array[j] = null;
                    return true;
                }
            }
            return false;
        }
    }

    public class Weapon extends Item {
        Weapon(int value) {
            this.value = value;
        }
    }

    public class Recover extends Item {
        Recover(int value) {
            this.value = value;
        }
    }

    public RPG(int size) {
        this.gird = new Item[size][size];
        //TODO random generate item and place it into grid
    }

    class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public class Player {
        int Hp;
        int moveRange;
        int x;
        int y;
        Backpack backpacks;

        Player(int Hp, int moveRange, int backpackSize) {
            this.Hp = Hp;
            this.moveRange = moveRange;
            this.x = 0;
            this.y = 0;
            this.backpacks = new Backpack(backpackSize);
        }

        private boolean isOutOfBound(int x, int y) {
            return x < 0 || x >= gird.length || y < 0 || y >= gird[0].length;
        }

        private List<Point> vision(int x, int y) {
            boolean[][] visited = new boolean[gird.length][gird.length];
            List<Point> result = new ArrayList<>();
            Queue<Point> queue = new LinkedList<>();

            Point start = new Point(x, y);
            result.add(start);
            queue.offer(start);
            visited[x][y] = false;
            int level = 0;
            while (!queue.isEmpty() && level < moveRange) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Point cur = queue.poll();
                    for (int[] direction : directions) {
                        int nextX = cur.x + direction[0];
                        int nextY = cur.y + direction[1];
                        if (!isOutOfBound(nextX, nextY) && !visited[nextX][nextY]) {
                            Point nextPoint = new Point(nextX, nextY);
                            result.add(nextPoint);
                            queue.offer(nextPoint);
                        }
                    }
                }
                level++;
            }
            return result;
        }

        public boolean goTo(int x, int y) throws Exception {
            List<Point> range = vision(x, y);
            for (Point p : range) {
                if (p.x == x && p.y == y) {
                    this.x = x;
                    this.y = y;
                    if (gird[x][y] != null) {
                        this.backpacks.add(gird[x][y]);
                    }
                    return true;
                }
            }
            return false;
        }

        public boolean remove(Item i) {
            return this.backpacks.remove(i);
        }
    }
}
