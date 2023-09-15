package auctions;

public class MinimumAuction extends  Auction {
    private Double minimumOffer;

    public MinimumAuction(String productName, User owner, double minimumOffered) {
        super(productName, owner);
        this.minimumOffer = minimumOffered;
    }

    @Override
    public boolean attempt(User user, Double offered) {
        if (offered < minimumOffer) return false;
        return super.attempt(user, offered);
    }

    public Double getMinimumOffer() {
        return minimumOffer;
    }

    public void setMinimumOffer(Double minimumOffer) {
        this.minimumOffer = minimumOffer;
    }
}
