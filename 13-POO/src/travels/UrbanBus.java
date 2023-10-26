package travels;

public class UrbanBus extends Bus {
    private Route route;

    public UrbanBus(String ID, Driver driver, float basePrice, Route route) {
        super(ID, driver, basePrice);
        this.route = route;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public float getPrice() {
        if (route == Route.A)
            return getBasePrice() * 1.10F;
        else
            return getBasePrice() * 1.20F;
    }
}
