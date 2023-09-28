import java.time.LocalDate;

public class Transaction {
    private final License asosiatedLicense;
    private final LocalDate createdAt;

    public Transaction(License asosiatedLicense) {
        this.asosiatedLicense = asosiatedLicense;
        this.createdAt = LocalDate.now();
    }

    public License getAsosiatedLicense() {
        return asosiatedLicense;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
