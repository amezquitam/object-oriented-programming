package auctions;

public class RestrictedAuction extends Auction {
    private int maxNumOfAttempts;
    public RestrictedAuction(String productName, User owner, int maxNumOfAttempts) {
        super(productName, owner);
        this.maxNumOfAttempts = maxNumOfAttempts;
    }

    @Override
    public boolean attempt(User user) {
        boolean success = super.attempt(user);

        if (getAttempts().size() == maxNumOfAttempts) {
            return execute();
        }

        return success;
    }

    public int getPendingAttempts() {
        return maxNumOfAttempts - getAttempts().size();
    }
}
