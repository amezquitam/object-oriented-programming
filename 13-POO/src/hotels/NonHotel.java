package hotels;

public abstract class NonHotel extends Lodging {
    private boolean isPrivate;
    private int area;

    public NonHotel(String name, String address, String location, String admin, boolean isPrivate, int area) {
        super(name, address, location, admin);
        this.isPrivate = isPrivate;
        this.area = area;
    }

    @Override
    public String toString() {
        return "------------------------------------\n" +
                "NonHotel:\n" +
                "\tisPrivate: " + isPrivate + '\n'+
                "\tarea: " + area + '\n';
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public int getArea() {
        return area;
    }
}
