package hotels;

public class Camping extends NonHotel {
    private int maxNumOfCarps;
    private int numOfBaths;
    private boolean hasRestaurant;

    public Camping(String name, String address, String location, String admin, boolean isPrivate, int area, int maxNumOfCarps, int numOfBaths, boolean hasRestaurant) {
        super(name, address, location, admin, isPrivate, area);
        this.maxNumOfCarps = maxNumOfCarps;
        this.numOfBaths = numOfBaths;
        this.hasRestaurant = hasRestaurant;
    }

    @Override
    public String toString() {
        return "------------------------------------\n" +
                "Camping:" +
                "\tisPrivate: " + isPrivate() + '\n'+
                "\tarea: " + getArea() + '\n' +
                "\tmaxNumOfCarps: " + maxNumOfCarps + '\n' +
                "\tnumOfBaths: " + numOfBaths + '\n' +
                "\thasRestaurant: " + hasRestaurant + '\n';
    }

    public int getMaxNumOfCarps() {
        return maxNumOfCarps;
    }

    public int getNumOfBaths() {
        return numOfBaths;
    }

    public boolean isHasRestaurant() {
        return hasRestaurant;
    }
}
