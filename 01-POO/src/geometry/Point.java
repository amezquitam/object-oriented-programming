package geometry;

import java.util.Arrays;

public class Point {
    private float x;
    private float y;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public Point(Point other) {
        this(other.x, other.y);
    }

    public void move(float dx, float dy) {
        x += dx;
        y += dy;
    }

    public void move(Direction direction) {
        Point directionPoint = getDirectionPoint(direction);
        move(directionPoint.x, directionPoint.y);
    }

    public float distance(Point other) {
        return (float) Math.sqrt(Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2));
    }

    public static Point faresPoint(Point... points) {
        var origin = new Point();
        var result = Arrays.stream(points).max((a, b) -> {
            return (int) (origin.distance(a) - origin.distance(b));
        });

        return result.get();
    }

    public static Point getDirectionPoint(Direction direction) {
        Point point = new Point();
        switch (direction) {
            case UP:
                point.setY(1);
            case DOWN:
                point.setY(-1);
            case LEFT:
                point.setX(-1);
            case RIGHT:
                point.setX(1);
        }
        return point;
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }
}
