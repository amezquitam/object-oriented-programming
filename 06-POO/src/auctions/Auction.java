package auctions;

import java.util.ArrayList;
import java.util.List;

public class Auction {
    private final String productName;
    private final User owner;
    private Boolean isOpened;
    private final List<Attempt> attempts;

    public Auction(String productName, User owner) {
        this.productName = productName;
        this.owner = owner;
        this.isOpened = true;
        this.attempts = new ArrayList<>();

        owner.getAuctions().add(this);
    }

    public boolean attempt(User user, Double offered) {
        Attempt greaterAttempt = getGreaterAttempt();
        if (!isOpen() || user.getCredit() < offered || user == owner)
            return false;
        if (greaterAttempt != null && greaterAttempt.getOffered() > offered)
            return false;
        return attempts.add(new Attempt(user, offered));
    }

    public boolean attempt(User user) {
        Attempt greaterAttempt = getGreaterAttempt();
        double greaterOffered = greaterAttempt != null ? greaterAttempt.getOffered() : 0.0;
        return attempt(user, greaterOffered + 1.0);
    }

    public boolean execute() {
        Attempt greaterAttempt = getGreaterAttempt();
        if (greaterAttempt == null) return false;
        User buyer = greaterAttempt.getOwner();
        double pay = greaterAttempt.getOffered();
        buyer.decrementCredit(pay);
        owner.incrementCredit(pay);
        close();
        return true;
    }

    private void close() {
        isOpened = false;
    }

    public String getProductName() {
        return productName;
    }

    public User getOwner() {
        return owner;
    }

    public Boolean isOpen() {
        return isOpened;
    }

    public List<Attempt> getAttempts() {
        return attempts;
    }

    public Attempt getGreaterAttempt() {
        return attempts.isEmpty() ? null : attempts.get(attempts.size() - 1);
    }

    @Override
    public String toString() {
        return "Auction{" +
                "productName='" + productName + '\'' +
                ", owner=" + owner +
                ", isOpened=" + isOpened +
                ", attempts=" + attempts +
                '}';
    }
}
