
import java.util.ArrayList;
import java.util.HashSet;

public class Bingo {
    private HashSet<Integer> unextractedBalls = new HashSet<>();
    private HashSet<Integer> extractedBalls = new HashSet<>();
    private ArrayList<Cardboard> cardboards = new ArrayList<>();
    private ArrayList<Cardboard> winnerCardboards = new ArrayList<>();
    private boolean done = false;

    public Bingo() {
        for (int i = 1; i <= 30; ++i) {
            unextractedBalls.add(i);
        }
    }
    
}
