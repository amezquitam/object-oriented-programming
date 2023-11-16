import java.util.*;

public class Dominoes {
    private final List<Player> players;
    private final List<Piece> remainingPieces;
    private final Table table;
    private int turn;

    public Dominoes() {
        table = new Table();
        players = new ArrayList<>();
        remainingPieces = new LinkedList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startMatch() {
        // Preconditions:
        assert (players.size() == 2);

        table.getPieces().clear();

        initPieces();

        firstMovement();

        // Let's play
        while (players.stream().noneMatch(Player::wins)) {
            Player playing = players.get(turn);

            Set<Integer> possibleNumbers = getPossibleNumbers();

            if (playing.hasPiecesTo(possibleNumbers)) {
                playing.show(table);
                Piece piece = playing.askMove(playing.possiblePieces(possibleNumbers));

                table.addPiece(piece);

                playing.removePiece(piece);
                changeTurn();
            } else if (!remainingPieces.isEmpty()) {
                playing.askPass(remainingPieces);
            } else {
                changeTurn();
            }
        }

        System.out.println("Winner: " + players.stream().filter(Player::wins).findAny().get().name);
    }

    private void changeTurn() {
        turn = (turn + 1) % players.size();
    }

    public void firstMovement() {
        // get player with the greatest double or value
        Player firstTurn = players.stream().max(Comparator.comparingInt(p -> p.maxPiece().value())).orElse(null);

        assert (firstTurn != null);

        Piece maxPiece = firstTurn.maxPiece();

        assert (maxPiece != null);

        turn = players.indexOf(firstTurn);

        firstTurn.removePiece(maxPiece);
        table.addPiece(maxPiece);

        changeTurn();
    }

    public void initPieces() {
        populatePieces();
        populatePlayers();
    }

    private void populatePieces() {
        remainingPieces.clear();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                remainingPieces.add(new Piece(i, j));
            }
        }
        Collections.shuffle(remainingPieces, new Random());
    }

    private void populatePlayers() {
        for (Player player : players) {
            player.removePieces();
            for (int i = 0; i < 7; i++) {
                player.givePiece(remainingPieces.remove(0));
            }
        }
    }

    private Set<Integer> getPossibleNumbers() {
        assert (table.hasPieces());

        Set<Integer> result = new HashSet<>();

        if (table.getPieces().size() == 1) {
            Piece piece = table.first();
            result.add(piece.getLeft());
            result.add(piece.getRight());
            return result;
        }

        // begin of the list
        Piece first = table.first();
        Piece second = table.second();
        result.add(first.unmatched(second));

        // end of the list
        Piece last = table.last();
        Piece penultimate = table.penultimate();
        result.add(last.unmatched(penultimate));

        return result;
    }
}
