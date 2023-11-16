import java.util.LinkedList;
import java.util.List;

public class Table {
    private final LinkedList<Piece> pieces;

    public Table() {
        this.pieces = new LinkedList<>();
    }

    public LinkedList<Piece> getPieces() {
        return pieces;
    }

    public boolean hasPieces() {
        return !pieces.isEmpty();
    }

    public boolean addPiece(Piece piece) {
        if (pieces.isEmpty()) {
            return pieces.add(piece);
        }

        if (matchesBegin(piece)) {
            pieces.addFirst(piece);
        } else if (matchesEnd(piece)) {
            pieces.addLast(piece);
        } else {
            return false;
        }

        return true;
    }

    private boolean matchesBegin(Piece piece) {
        if (pieces.size() == 1) {
            var uniquePiece = pieces.getFirst();
            return piece.has(List.of(uniquePiece.getRight(), uniquePiece.getLeft()));
        }

        var first = pieces.getFirst();
        var second = pieces.get(1);

        int value = first.unmatched(second);

        return piece.has(value);
    }

    private boolean matchesEnd(Piece piece) {
        var last = pieces.getLast();
        var penultimate = pieces.get(pieces.size() - 2);

        int value = last.unmatched(penultimate);

        return piece.has(value);
    }

    public Piece last() {
        return pieces.getLast();
    }

    public Piece penultimate() {
        return pieces.get(pieces.size() - 1);
    }

    public Piece first() {
        return pieces.getFirst();
    }

    public Piece second() {
        return pieces.get(1);
    }

}
