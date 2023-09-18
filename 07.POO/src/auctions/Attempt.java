package auctions;

public class Attempt {
    private User owner;
    private Double offered;

    public Attempt(User owner, Double offered) {
        this.owner = owner;
        this.offered = offered;
    }

    public User getOwner() {
        return owner;
    }

    public Double getOffered() {
        return offered;
    }

    @Override
    public String toString() {
        return "Attempt{" +
                "owner=" + owner +
                ", offered=" + offered +
                '}';
    }
}
