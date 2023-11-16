import javax.swing.*;
import java.awt.*;

public class DominoUI extends JFrame {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    public static final int PIECE_SIZE = 50;
    public static final int GAP = 10;

    public DominoUI() {
        setTitle("Dominó UI");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        DominoPanel dominoPanel = new DominoPanel();
        add(dominoPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DominoUI());
    }
}

class DominoPanel extends JPanel {

    private static final int ROWS = 2;
    private static final int COLS = 3;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        int startX = 50;
        int startY = 50;

        int value = 1;

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                drawDominoPiece(g2d, startX + j * (DominoUI.PIECE_SIZE + DominoUI.GAP),
                        startY + i * (DominoUI.PIECE_SIZE + DominoUI.GAP), value++);
            }
        }
    }

    private void drawDominoPiece(Graphics2D g2d, int x, int y, int value) {
        // Draw the domino piece as a rectangle
        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(x, y, DominoUI.PIECE_SIZE, DominoUI.PIECE_SIZE, 10, 10);

        // Draw dots on the domino piece based on the value
        g2d.setColor(Color.BLACK);

        int dotSize = 10;
        int dotGap = 5;

        switch (value) {
            case 1:
                drawDot(g2d, x + DominoUI.PIECE_SIZE / 2 - dotGap, y + DominoUI.PIECE_SIZE / 2 - dotGap);
                break;
            case 2:
                drawDot(g2d, x + dotGap, y + dotGap);
                drawDot(g2d, x + DominoUI.PIECE_SIZE - dotSize - dotGap, y + DominoUI.PIECE_SIZE - dotSize - dotGap);
                break;
            case 3:
                drawDot(g2d, x + dotGap, y + dotGap);
                drawDot(g2d, x + DominoUI.PIECE_SIZE / 2 - dotGap, y + DominoUI.PIECE_SIZE / 2 - dotGap);
                drawDot(g2d, x + DominoUI.PIECE_SIZE - dotSize - dotGap, y + DominoUI.PIECE_SIZE - dotSize - dotGap);
                break;
            case 4:
                drawDot(g2d, x + dotGap, y + dotGap);
                drawDot(g2d, x + DominoUI.PIECE_SIZE - dotSize - dotGap, y + dotGap);
                drawDot(g2d, x + dotGap, y + DominoUI.PIECE_SIZE - dotSize - dotGap);
                drawDot(g2d, x + DominoUI.PIECE_SIZE - dotSize - dotGap, y + DominoUI.PIECE_SIZE - dotSize - dotGap);
                break;
            case 5:
                drawDot(g2d, x + dotGap, y + dotGap);
                drawDot(g2d, x + DominoUI.PIECE_SIZE - dotSize - dotGap, y + dotGap);
                drawDot(g2d, x + DominoUI.PIECE_SIZE / 2 - dotGap, y + DominoUI.PIECE_SIZE / 2 - dotGap);
                drawDot(g2d, x + dotGap, y + DominoUI.PIECE_SIZE - dotSize - dotGap);
                drawDot(g2d, x + DominoUI.PIECE_SIZE - dotSize - dotGap, y + DominoUI.PIECE_SIZE - dotSize - dotGap);
                break;
            case 6:
                drawDot(g2d, x + dotGap, y + dotGap);
                drawDot(g2d, x + DominoUI.PIECE_SIZE - dotSize - dotGap, y + dotGap);
                drawDot(g2d, x + dotGap, y + DominoUI.PIECE_SIZE / 2 - dotSize / 2);
                drawDot(g2d, x + DominoUI.PIECE_SIZE - dotSize - dotGap, y + DominoUI.PIECE_SIZE / 2 - dotSize / 2);
                drawDot(g2d, x + dotGap, y + DominoUI.PIECE_SIZE - dotSize - dotGap);
                drawDot(g2d, x + DominoUI.PIECE_SIZE - dotSize - dotGap, y + DominoUI.PIECE_SIZE - dotSize - dotGap);
                break;
        }
    }

    private void drawDot(Graphics2D g2d, int x, int y) {
        g2d.fillOval(x, y, 10, 10);
    }
}
