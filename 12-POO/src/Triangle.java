public abstract class Triangle implements Figure {
    private int sideA;
    private int sideB;
    private double tetha;

    public Triangle(int sideA, int sideB, double tetha) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.tetha = tetha;
    }

    public int getSideA() {
        return sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public abstract void drawText();

    @Override
    public double getArea() {
        return sideA * sideB * Math.sin(tetha) / 2;
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + getSideC();
    }

    private double getSideC() {
        return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2) - 2 * sideA * sideB * Math.cos(tetha));
    }
    
}
