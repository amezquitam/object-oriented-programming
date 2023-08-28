package test;

import geometry.Circle;
import geometry.Direction;
import geometry.Point;

public class CircleTest {
    public static void main(String[] args) {
        Point point1 = new Point(2, 3);
        point1.move(Direction.UP);
        System.out.println(point1);
        Point point2 = new Point(4, 2);
        float distance12 = point1.distance(point2);
        System.out.println("Distance from point1 to point2: " + distance12);
        Point farePoint = Point.faresPoint(point1, point2);
        System.out.println("farest point from origin: " + farePoint);

        Circle circle1 = new Circle(point1, 3);
        Circle circle2 = new Circle(point1, 5);

        circle1.move(3, 2);

        System.out.println("circle1: " + circle1);
        System.out.println("circle2: " + circle2);

        Point center = circle2.getCenter();

        center.move(Direction.DOWN);

        System.out.println("Center of circle2: " + circle2.getCenter());
        System.out.println("Center variable: " + center);

        circle2.scale(1.5F);

        System.out.println("circle2: " + circle2);
    }
}
