package hotels;

public class FourStarHotel extends ThreeStarHotel {
    private final String restaurantName;
    private final int restaurantCapacity;
    private final GymType gymType;

    public FourStarHotel(String name, String address, String location, String admin, int nHabitations, int nBeds, int nFloors, String restaurantName, int restaurantCapacity, GymType gymType) {
        super(name, address, location, admin, nHabitations, nBeds, nFloors);
        this.restaurantName = restaurantName;
        this.restaurantCapacity = restaurantCapacity;
        this.gymType = gymType;
    }

    public float getAdditionalByRestaurant() {
        if (getRestaurantCapacity() < 30)
            return 10.0F;
        if (getRestaurantCapacity() < 50)
            return 30.0F;
        return 50.0F;
    }

    @Override
    public String toString() {
        return "------------------------------------\n" +
                "FourStarHotel:\n" +
                "\tname: " + getName() + '\n' +
                "\taddress: " + getAddress() + '\n' +
                "\tlocation: " + getLocation() + '\n' +
                "\tadmin: " + getAdmin() + '\n' +
                "\tnHabitations: " + getNumOfHabitations() + '\n' +
                "\tnBeds: " + getNumOfBeds() + '\n' +
                "\tnFloors: " + getNumOfFloors() + '\n' +
                "\trestaurantName: " + restaurantName + '\n' +
                "\trestaurantCapacity: " + restaurantCapacity + '\n' +
                "\tgymType: " + gymType + '\n';
    }

    public float getAdditionalByGym() {
        if (gymType == GymType.A) {
            return 50.0F;
        } else {
            return 30.0F;
        }
    }

    @Override
    public float getHabitationPrice() {
        return super.getHabitationPrice() + getAdditionalByRestaurant() + getAdditionalByGym();
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public int getRestaurantCapacity() {
        return restaurantCapacity;
    }

    public GymType getGymType() {
        return gymType;
    }
}
