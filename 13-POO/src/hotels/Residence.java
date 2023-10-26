package hotels;

public class Residence extends NonHotel {
    private int numOfHabitations;
    private boolean hasDiscountToGroups;
    private boolean hasSportsGround;

    public Residence(String name, String address, String location, String admin, boolean isPrivate, int area, int numOfHabitations, boolean hasDiscountToGroups, boolean hasSportsGround) {
        super(name, address, location, admin, isPrivate, area);
        this.numOfHabitations = numOfHabitations;
        this.hasDiscountToGroups = hasDiscountToGroups;
        this.hasSportsGround = hasSportsGround;
    }

    @Override
    public String toString() {
        return "------------------------------------\n" +
                "Residence:\n" +
                "\tisPrivate: " + isPrivate() + '\n'+
                "\tarea: " + getArea() + '\n' +
                "\tnumOfHabitations: " + numOfHabitations + '\n' +
                "\thasDiscountToGroups: " + hasDiscountToGroups + '\n' +
                "\thasSportsGround: " + hasSportsGround + '\n';
    }

    public int getNumOfHabitations() {
        return numOfHabitations;
    }

    public boolean isHasDiscountToGroups() {
        return hasDiscountToGroups;
    }

    public boolean isHasSportsGround() {
        return hasSportsGround;
    }
}
