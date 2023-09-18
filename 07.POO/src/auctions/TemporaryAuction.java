package auctions;

public class TemporaryAuction extends RestrictedAuction {
    // 3s as 1h
    private static final Long MILLIS_PER_HOUR = 3_000L;
    private Long createdAt;
    private Long endsAt;

    public TemporaryAuction(String productName, User owner, int durationInHours) {
        super(productName, owner, durationInHours * 2);
        this.createdAt = System.currentTimeMillis();
        this.endsAt = createdAt + durationInHours * MILLIS_PER_HOUR;
    }

    public float remainingTime() {
        return endsAt - System.currentTimeMillis();
    }

    @Override
    public Boolean isOpen() {
        return remainingTime() > 0 && super.isOpen();
    }
}
