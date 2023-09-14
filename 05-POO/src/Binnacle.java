import java.util.LinkedList;


public class Binnacle {
    private final String id;
    private LinkedList<Input> inputs;

    public Binnacle(String id) {
        this.id = id;
        this.inputs = new LinkedList<>();
    }

    public int getNumberOfInputs() {
        return inputs.size();
    }

    public String getId() {
        return id;
    }

    protected LinkedList<Input> getInputs() {
        return inputs;
    }

    public boolean addInput(String event) {
        Input input = new Input(event);
        return this.inputs.add(input);
    }
    
}
