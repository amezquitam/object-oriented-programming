import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class SelectiveTrip extends Trip {
    List<String> vetoedUsers;

    public SelectiveTrip(String carOwner, String carModel, String route, LocalDate startDate, int places) {
        super(carOwner, carModel, route, startDate, places);
        this.vetoedUsers = new LinkedList<>();
    }

    public void veto(String user) {
        vetoedUsers.add(user);
    }

    public void unvet(String user) {
        vetoedUsers.remove(user);
    }

    public Reservation reserve(String user, int numOfPlacesRequired) {
        if (vetoedUsers.contains(user)) {
            return null;
        }
        return super.reserve(user, numOfPlacesRequired);
    }

    @Override
    public String toString() {
        return "SelectiveTrip [" + super.toString() + ", " + "vetoedUsers=" + vetoedUsers + "]";
    }
}
