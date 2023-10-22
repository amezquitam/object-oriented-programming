public class Rectangle implements Figure {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawText() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    
}
