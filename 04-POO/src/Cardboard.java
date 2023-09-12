import java.util.ArrayList;
import java.util.List;

public class Cardboard {
    public static final int MAX_BOXES_PER_CARDBOARD = 9;
    private final List<Integer> numbers;
    public Cardboard(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }
    public final List<Integer> getNumbers() {
        return numbers;
    }
    public int getSize() {
        return MAX_BOXES_PER_CARDBOARD;
    }
}
