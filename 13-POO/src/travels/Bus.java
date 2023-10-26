package travels;

public abstract class Bus {
    private String ID;
    private Driver driver;
    private float basePrice;

    public Bus(String ID, Driver driver, float basePrice) {
        this.ID = ID;
        this.driver = driver;
        this.basePrice = basePrice;
    }

    public abstract float getPrice();

    public String getID() {
        return ID;
    }

    public Driver getDriver() {
        return driver;
    }

    public float getBasePrice() {
        return basePrice;
    }
}
