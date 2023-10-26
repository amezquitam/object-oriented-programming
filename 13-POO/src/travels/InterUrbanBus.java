package travels;

public class InterUrbanBus extends Bus {
    private int kilometersToTravel;

    public InterUrbanBus(String ID, Driver driver, float basePrice, int kilometersToTravel) {
        super(ID, driver, basePrice);
        this.kilometersToTravel = kilometersToTravel;
    }

    public int getKilometersToTravel() {
        return kilometersToTravel;
    }

    public void setKilometersToTravel(int kilometersToTravel) {
        this.kilometersToTravel = kilometersToTravel;
    }

    @Override
    public float getPrice() {
        return getBasePrice() * kilometersToTravel;
    }
}
