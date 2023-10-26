package hotels;

public class Lodging {
    private String name;
    private String address;
    private String location;
    private String admin;

    public Lodging(String name, String address, String location, String admin) {
        this.name = name;
        this.address = address;
        this.location = location;
        this.admin = admin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }

    public String getAdmin() {
        return admin;
    }
}
