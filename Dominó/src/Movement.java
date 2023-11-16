public class Movement {
    private final Piece piece;
    private final boolean atEnd;

    public Movement(Piece piece, boolean atEnd) {
        this.piece = piece;
        this.atEnd = atEnd;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isAtEnd() {
        return atEnd;
    }
}
