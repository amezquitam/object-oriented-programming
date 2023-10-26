package hotels;

public class ThreeStarHotel extends Hotel {
    private final int nHabitations;
    private final int nBeds;
    private final int nFloors;

    public ThreeStarHotel(String name, String address, String location, String admin, int nHabitations, int nBeds, int nFloors) {
        super(name, address, location, admin);
        this.nHabitations = nHabitations;
        this.nBeds = nBeds;
        this.nFloors = nFloors;
    }

    @Override
    public float getHabitationPrice() {
        return 50.0F + getNumOfHabitations();
    }

    public int getNumOfHabitations() {
        return nHabitations;
    }

    public int getNumOfBeds() {
        return nBeds;
    }

    public int getNumOfFloors() {
        return nFloors;
    }

    @Override
    public String toString() {
        return "------------------------------------\n" +
                "ThreeStarHotel:\n" +
                "\tname: " + getName() + '\n' +
                "\taddress: " + getAddress() + '\n' +
                "\tlocation: " + getLocation() + '\n' +
                "\tadmin: " + getAdmin() + '\n' +
                "\tnHabitations: " + nHabitations + '\n' +
                "\tnBeds: " + nBeds + '\n' +
                "\tnFloors: " + nFloors + '\n';
    }
}
