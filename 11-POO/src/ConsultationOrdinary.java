public class ConsultationOrdinary extends Consultation {
    private boolean isOpened;

    public ConsultationOrdinary(String title, int numberOfQuestions) {
        super(title, numberOfQuestions);
        isOpened = false;
    }

    public void open() {
        isOpened = true;
    }

    public void close() {
        isOpened = false;
    }

    @Override
    public boolean isActive() {
        return isOpened;
    }
}
