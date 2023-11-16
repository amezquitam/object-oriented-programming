
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class Player {
    protected final String name;
    protected final List<Piece> pieces;

    public Player(String name) {
        this.name = name;
        this.pieces = new LinkedList<>();
    }

    public abstract Piece askMove(List<Piece> possiblePieces);

    public abstract void askPass(List<Piece> remainingPieces);

    public void show(Table table) {
    }

    public boolean hasPiecesTo(Set<Integer> possibleNumbers) {
        return !possiblePieces(possibleNumbers).isEmpty();
    }

    public List<Piece> possiblePieces(Set<Integer> possibleNumbers) {
        return pieces.stream().filter(piece -> piece.has(possibleNumbers)).toList();
    }

    /**
     * Add a piece to the player
     */
    public void givePiece(Piece piece) {
        pieces.add(piece);
    }

    public void removePieces() {
        pieces.clear();
    }

    public void removePiece(Piece piece) {
        pieces.remove(piece);
    }


    /**
     * Returns the max double of this player or the max piece
     */
    public Piece maxPiece() {
        if (pieces.isEmpty())
            return null;

        var piece = pieces.stream().filter(Piece::isDouble).max(Comparator.comparing(Piece::getLeft)).orElse(null);

        if (piece != null) {
            return piece;
        }

        return pieces.stream().max(Comparator.comparing(Piece::value)).orElse(null);
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public String getName() {
        return name;
    }

    public boolean wins() {
        return pieces.isEmpty();
    }
}
