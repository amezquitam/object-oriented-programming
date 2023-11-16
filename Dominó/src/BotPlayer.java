
import java.util.List;

public class BotPlayer extends Player {
    public BotPlayer(String name) {
        super(name);
    }

    @Override
    public Piece askMove(List<Piece> possiblePieces) {
        return possiblePieces.get(0);
    }

    @Override
    public void askPass(List<Piece> remainingPieces) {
        pieces.add(remainingPieces.remove(0));
    }
}
