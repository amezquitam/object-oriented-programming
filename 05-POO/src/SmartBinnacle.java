
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SmartBinnacle extends Binnacle {
    private final List<String> forbiddenWords;
    private final Map<String, List<Input>> spam;

    public SmartBinnacle(String id, String... forbiddenWords) {
        super(id);
        this.spam = new HashMap<>();
        this.forbiddenWords = Arrays.asList(forbiddenWords);
        for (String forbiddenWord : forbiddenWords) {
            this.spam.put(forbiddenWord, new LinkedList<>());
        }
    }

    @Override
    public boolean addInput(String event) {
        boolean containsForbiddenWord = forbiddenWords.stream().anyMatch(
                forbiddenWord -> {
                    if (!event.contains(forbiddenWord))
                        return false;
                    return spam.get(forbiddenWord).add(new Input(event));
                });

        return !containsForbiddenWord && super.addInput(event);
    }

}
