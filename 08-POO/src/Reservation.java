import java.time.LocalDate;
import java.util.UUID;

public class Reservation {
    private UUID code;
    private String user;
    private int numOfPlaces;
    private LocalDate date;

    public Reservation(String user, int numOfPlaces) {
        this.user = user;
        this.numOfPlaces = numOfPlaces;
        this.code = UUID.randomUUID();
        this.date = LocalDate.now();
    }

    public UUID getCode() {
        return code;
    }

    public String getUser() {
        return user;
    }

    public int getNumOfPlaces() {
        return numOfPlaces;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Reservation [code=" + code + ", user=" + user + ", numOfPlaces=" + numOfPlaces + ", date=" + date + "]";
    }    

    
}
