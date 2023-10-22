public class Square extends Rectangle {

    public Square(int sideLen) {
        super(sideLen, sideLen);
    }

    @Override
    public String getName() {
        return "Square";
    }
}
