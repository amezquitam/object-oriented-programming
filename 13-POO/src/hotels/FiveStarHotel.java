package hotels;

public class FiveStarHotel extends FourStarHotel {
    private final int nRoomsOfMeeting;
    private final int nLimousines;
    private final int nSuites;

    public FiveStarHotel(String name, String address, String location, String admin, int nHabitations, int nBeds, int nFloors, String restaurantName, int restaurantCapacity, GymType gymType, int nRoomsOfMeeting, int nLimousines, int nSuites) {
        super(name, address, location, admin, nHabitations, nBeds, nFloors, restaurantName, restaurantCapacity, gymType);
        this.nRoomsOfMeeting = nRoomsOfMeeting;
        this.nLimousines = nLimousines;
        this.nSuites = nSuites;
    }

    @Override
    public float getHabitationPrice() {
        return super.getHabitationPrice() + getNumOfLimousines() * 15.0F;
    }

    public int getNumOfMeetingRooms() {
        return nRoomsOfMeeting;
    }

    public int getNumOfLimousines() {
        return nLimousines;
    }

    public int getNumOfSuites() {
        return nSuites;
    }

    @Override
    public String toString() {
        return "------------------------------------\n" +
                "FiveStarHotel:\n" +
                "\tname: " + getName() + '\n' +
                "\taddress: " + getAddress() + '\n' +
                "\tlocation: " + getLocation() + '\n' +
                "\tadmin: " + getAdmin() + '\n' +
                "\tnHabitations: " + getNumOfHabitations() + '\n' +
                "\tnBeds: " + getNumOfBeds() + '\n' +
                "\tnFloors: " + getNumOfFloors() + '\n' +
                "\trestaurantName: " + getRestaurantName() + '\n' +
                "\trestaurantCapacity: " + getRestaurantCapacity() + '\n' +
                "\tgymType: " + getGymType() + '\n' +
                "\tnRoomsOfMeeting: " + nRoomsOfMeeting + '\n' +
                "\tnLimousines: " + nLimousines + '\n' +
                "\tnSuites: " + nSuites + '\n';
    }
}
