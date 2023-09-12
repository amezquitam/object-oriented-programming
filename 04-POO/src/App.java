public class App {
    public static void main(String[] args) {
        Bingo bingo = new Bingo();

        bingo.generateCardboard();
        bingo.generateCardboard();
        bingo.generateCardboard();

        for (Cardboard cardboard : bingo.getCardboards()) {
            System.out.println(cardboard.getNumbers());
        }

        while (!bingo.isDone()) {
            System.out.println("Ball extracted: " + bingo.extractBall());
        }

        System.out.println("Winners: ");
        for (Cardboard winner : bingo.getWinnerCardboards()) {
            System.out.println(winner.getNumbers());
        }
    }
}
