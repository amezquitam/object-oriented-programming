package travels;

public class App {
    public static void main(String[] args) {
        Driver juan = new Driver("Juan Lozada", 2_740_000);
        Bus[] buses = new Bus[] {
            new UrbanBus("1", juan, 0.4F, Route.B),
            new InterUrbanBus("2", juan, 0.05F, 6)
        };

        for (int i = 0; i < buses.length; i++) {
            var bus = buses[i];
            System.out.printf("%d-th case\nprice: %f\nID: %s\nDriver: %s\n", i + 1, bus.getPrice(), bus.getID(), bus.getDriver().getName());
        }
    }
}
