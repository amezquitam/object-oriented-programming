public class UndoBinnacle extends Binnacle {
    private Input lastInput;

    public UndoBinnacle(String id) {
        super(id);
    }

    @Override
    public boolean addInput(String event) {
        return super.addInput(event) && setLast(getInputs().getLast());
    }

    private boolean setLast(Input input) {
        lastInput = input;
        return true;
    }

    public boolean undo() {
        return getInputs().remove(lastInput);
    }
    
}
