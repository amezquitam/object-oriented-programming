import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bingo {
    private static final int MAX_BALL = 30;
    private List<Integer> unextractedBalls;
    private List<Integer> extractedBalls = new ArrayList<>();
    private List<Cardboard> cardboards = new ArrayList<>();
    private List<Cardboard> winnerCardboards = new ArrayList<>();

    public Bingo() {
        unextractedBalls = IntStream.range(1, MAX_BALL).boxed().collect(Collectors.toList());
    }

    public boolean checkCardboard(Cardboard cardboard) {
        return new HashSet<>(extractedBalls).containsAll(cardboard.getNumbers());
    }

    public Cardboard generateCardboard() {
        List<Integer> possibleNumbers = IntStream.range(1, MAX_BALL).boxed().collect(Collectors.toList());
        Collections.shuffle(possibleNumbers);
        List<Integer> cardNumbers = new ArrayList<>();
        for (int i = 0; i < Cardboard.MAX_BOXES_PER_CARDBOARD; i++) {
            cardNumbers.add(possibleNumbers.remove(0));
        }
        Cardboard cardboard = new Cardboard(cardNumbers);
        cardboards.add(cardboard);
        return cardboard;
    }

    public int extractBall() {
        if (isDone()) return 0;
        Collections.shuffle(unextractedBalls);
        int ball = unextractedBalls.remove(0);
        extractedBalls.add(ball);

        for (Cardboard cardboard : cardboards) {
            if (winnerCardboards.contains(cardboard)) {
                continue;
            }
            if (checkCardboard(cardboard)) {
                winnerCardboards.add(cardboard);
            }
        }

        return ball;
    }

    public List<Integer> getUnextractedBalls() {
        return new ArrayList<>(unextractedBalls);
    }

    public List<Integer> getExtractedBalls() {
        return new ArrayList<>(extractedBalls);
    }

    public List<Cardboard> getCardboards() {
        return new ArrayList<>(cardboards);
    }

    public List<Cardboard> getWinnerCardboards() {
        return winnerCardboards;
    }

    public boolean isDone() {
        return unextractedBalls.isEmpty() || !winnerCardboards.isEmpty();
    }
}
