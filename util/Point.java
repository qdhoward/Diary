package util;

public class Point {
    public int x;
    public int y;
    public int cost;
    public Point(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
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
