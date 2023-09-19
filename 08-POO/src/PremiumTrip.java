import java.time.LocalDate;
import java.util.UUID;

public class PremiumTrip extends Trip {
    
    public PremiumTrip(String carOwner, String carModel, String route, LocalDate startDate, int places) {
        super(carOwner, carModel, route, startDate, places);
    }

    public boolean cancel(UUID code) {
        Reservation reservation = getReservationByCode(code);
        if (reservation == null) return false;
        if (getStartDate().isBefore(LocalDate.now())) {
            return false;
        }
        return getReservations().remove(reservation);
    }
}
