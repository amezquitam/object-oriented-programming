package auctions;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private Double credit;
    private final List<Auction> auctions;

    public User(String name, Double credit) {
        this.name = name;
        this.credit = credit;
        this.auctions = new ArrayList<>();
    }

    public User(String name) {
        this(name, 0.0);
    }

    public void incrementCredit(Double delta) {
        assert(delta > 0.0);
        this.credit += delta;
    }

    public void decrementCredit(Double delta) {
        assert(delta > 0.0);
        this.credit -= delta;
    }

    public String getName() {
        return name;
    }

    public Double getCredit() {
        return credit;
    }

    public List<Auction> getAuctions() {
        return auctions;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", credit=" + credit +
                '}';
    }
}
