import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Trip {
    private String carOwner;
    private String carModel;
    private String route;
    private LocalDate startDate;
    private int places;
    private List<Reservation> reservations;

    public Trip(String carOwner, String carModel, String route, LocalDate startDate, int places) {
        this.carOwner = carOwner;
        this.carModel = carModel;
        this.route = route;
        this.startDate = startDate;
        this.places = places;
        this.reservations = new LinkedList<>();
    }

    public Trip(String carOwner, String carModel, String route, LocalDate startDate) {
        this(carOwner, carModel, route, startDate, 1);
    }

    public String getCarOwner() {
        return carOwner;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getRoute() {
        return route;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getPlaces() {
        return places;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public int getAvailablePlaces() {
        return places - reservations.stream().reduce(0, (accum, reservation) -> accum + reservation.getNumOfPlaces(), Integer::sum);
    }

    Reservation reserve(String user, int numOfPlacesRequired) {
        if (getAvailablePlaces() < numOfPlacesRequired || startDate.isBefore(LocalDate.now())) {
            return null;
        }
        Reservation newReservation = new Reservation(user, numOfPlacesRequired);
        reservations.add(newReservation);
        return newReservation;
    }

    Reservation getReservationByCode(UUID code) {
        return reservations.stream().filter(reservation -> reservation.getCode().equals(code)).findFirst().orElse(null);
    }

    @Override
    public String toString() {
        return "Trip [carOwner=" + carOwner + ", carModel=" + carModel + ", route=" + route + ", startDate=" + startDate + ", places=" + places + ", reservations=" + reservations + "]";
    }

}
