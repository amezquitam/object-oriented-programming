import java.util.List;
import java.util.Scanner;

public class PersonPlayer extends Player {
    public PersonPlayer(String name) {
        super(name);
    }

    @Override
    public Piece askMove(List<Piece> possiblePieces) {

        for (int i = 0; i < possiblePieces.size(); i++) {
            System.out.println((i + 1) + ". " + possiblePieces.get(i));
        }

        System.out.print("Qué pieza desea mover?: ");
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        return possiblePieces.get(input - 1);
    }

    @Override
    public void askPass(List<Piece> remainingPieces) {
        pieces.add(remainingPieces.remove(0));
    }

    @Override
    public void show(Table table) {
        table.getPieces().forEach(System.out::print);
        System.out.println();
    }
}
