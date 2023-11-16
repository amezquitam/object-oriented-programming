import java.util.List;

public interface GameContext {
    List<Piece> getPieceOnTable();

    List<Piece> getPiecesOnPile();

    void transferPiece();
}
