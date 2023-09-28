import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class License {
    private final String userEmail;
    private LocalDate activatedAt;
    private String code;
    private List<Transaction> transactions;
    private boolean revoked;
    private String urlService;

    public License(String userEmail, String urlService) {
        this.userEmail = userEmail;
        this.activatedAt = LocalDate.now();
        this.code = UUID.randomUUID().toString();
        this.transactions = new LinkedList<>();
        this.revoked = false;
        this.urlService = urlService;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public LocalDate getActivatedAt() {
        return activatedAt;
    }

    public String getCode() {
        return code;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public boolean isRevoked() {
        return revoked;
    }

    public String getUrlService() {
        return urlService;
    }

    public void revoke() {
        this.revoked = true;
    }

    public void reactivate() {
        if (!isRevoked()) return;
        this.revoked = false;
        this.activatedAt = LocalDate.now();
    }

    public int getNumOfTransactions() {
        return getTransactions().size();
    }

    protected abstract boolean isApplicable();

    public Transaction getAuthorizationOfTheService() {
        if (isRevoked() || !isApplicable()) return null;
        Transaction transaction = new Transaction(this);
        getTransactions().add(transaction);
        return transaction;
    }
}
