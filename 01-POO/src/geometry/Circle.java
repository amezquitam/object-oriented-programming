package geometry;

public class Circle {
    private float radius;
    
    private Point center;
    
    public float getRadius() {
        return radius;
    }

    public Point getCenter() {
        return new Point(center);
    }
    
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public Circle(Point center, float radius) {
        this.center = new Point(center);
        this.radius = radius;
    }

    public Circle() {
        this(new Point(), 5);
    }

    public Circle(Circle other) {
        this(other.center, other.radius);
    }

    public void move(float dx, float dy) {
        center.move(dx, dy);
    }

    public void move(Point posPoint) {
        center = new Point(posPoint);
    }

    public void scale(float factor) {
        radius *= factor;
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", center=" + center + "]";
    }

}
