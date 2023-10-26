package hotels;

public abstract class Hotel extends Lodging {
    public Hotel(String name, String address, String location, String admin) {
        super(name, address, location, admin);
    }

    public abstract float getHabitationPrice();
}
