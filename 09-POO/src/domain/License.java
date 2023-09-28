package domain;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public abstract class License implements Cloneable {
    private final String userEmail;
    private LocalDate activatedAt;
    private String code;
    private List<Transaction> transactions;
    private boolean revoked;
    private final String urlService;

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

    protected abstract boolean isNotApplicable();

    public Transaction getAuthorizationToTheService() {
        if (isRevoked() || isNotApplicable()) return null;
        Transaction transaction = new Transaction(this);
        getTransactions().add(transaction);
        return transaction;
    }

    @Override
    public License clone() {
        try {
            License clone = (License) super.clone();
            clone.activatedAt = LocalDate.now();
            clone.code = UUID.randomUUID().toString();
            clone.transactions = List.copyOf(clone.transactions);
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "\nLicense {\n" +
                "userEmail='" + userEmail + '\'' + '\n' +
                "activatedAt=" + activatedAt + '\n' +
                "code='" + code + '\'' + '\n' +
                "transactions=" + transactions + '\n' +
                "revoked=" + revoked + '\n' +
                "urlService='" + urlService + '\'' + '\n' +
                "}";
    }
}
