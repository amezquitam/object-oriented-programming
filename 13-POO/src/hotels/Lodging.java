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

    @Override
    public String toString() {
        return "------------------------------------\n" +
                "Lodging:\n" +
                "\tname: " + name + '\n' +
                "\taddress: " + address + '\n' +
                "\tlocation: " + location + '\n' +
                "\tadmin: " + admin + '\n';
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
