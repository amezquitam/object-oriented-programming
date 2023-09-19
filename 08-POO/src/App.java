import java.time.LocalDate;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Trip mcg = new Trip("José Antonio", "Seat León", "Murcia-Cartagena", LocalDate.of(2023, 9, 19));
        SelectiveTrip mca = new SelectiveTrip("José Antonio", "Seat León", "Murcia-Campus", LocalDate.of(2023, 9, 20),
                4);
        mca.veto("Beatriz");
        PremiumTrip mba = new PremiumTrip("José Antonio", "Seat León", "Murcia-Barcelona", LocalDate.of(2023, 9, 19),
                6);

        System.out.println(mcg);
        System.out.println(mca);
        System.out.println(mba);
        System.out.println("-----------");

        Reservation alberto = mcg.reserve("Alberto", 2);
        Reservation enrique = mca.reserve("Enrique", 3);
        Reservation beatriz = mca.reserve("Beatriz", 1);
        Reservation ana = mba.reserve("Ana", 2);

        System.out.println(alberto);
        System.out.println(enrique);
        System.out.println(beatriz);
        System.out.println(ana);
        System.out.println("-----------");


        mba.cancel(ana.getCode());

        Set<Trip> trips = Set.of(mcg, mca, mba);

        trips.forEach((trip) -> {
            if (trip instanceof SelectiveTrip)
                ((SelectiveTrip) trip).unvet("Beatriz");
            System.out.println(trip);
        });
    }
}
