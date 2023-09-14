import java.time.LocalDate;

public class Input {
    private String event;
    private LocalDate date;

    public Input(String event) {
        this.event = event;
        this.date = LocalDate.now();
    }

    public String getEvent() {
        return event;
    }

    public LocalDate getDate() {
        return date;
    }

}
