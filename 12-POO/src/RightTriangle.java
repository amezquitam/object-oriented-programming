public class RightTriangle extends Triangle {

    public RightTriangle(int width, int height) {
        super(width, height, Math.PI / 2);
    }

    @Override
    public void drawText() {
        double x = 1.0;
        double dx = (double) getSideA() / (double) getSideB();

        for (int i = 0; i < getSideB(); i++) {
            for (int j = 0; j < (int) x; j++) {
                System.out.print(" ^ ");
            }
            x += dx;
            System.out.println();
        }
    }
    
}
