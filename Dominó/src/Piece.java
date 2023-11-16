import java.util.Collection;

public class Piece implements Comparable<Piece> {
    private final int right;
    private final int left;

    public Piece(int right, int left) {
        assert (0 <= right && right <= 6);
        assert (0 <= left && left <= 6);

        this.right = right;
        this.left = left;
    }

    /**
     * Check if the piece has value
     */
    public boolean has(int value) {
        return value == right || value == left;
    }

    /**
     * Check if the piece contains a value in the list
     */
    public boolean has(Collection<Integer> values) {
        return values.stream().anyMatch(this::has);
    }

    /**
     * Return the value of this piece that doesn't match with any value
     * of the passed piece
     */
    public int unmatched(Piece piece) {
        if (piece.has(left))
            return right;
        else if (piece.has(right))
            return left;
        else
            return -1;
    }

    public boolean isDouble() {
        return right == left;
    }

    public int value() {
        return right + left;
    }

    @Override
    public int compareTo(Piece o) {
        if (o == null) return -1;
        return value() - o.value();
    }

    public int getRight() {
        return right;
    }

    public int getLeft() {
        return left;
    }

    @Override
    public String toString() {
        return "[%d, %d]".formatted(left, right);
    }
}
