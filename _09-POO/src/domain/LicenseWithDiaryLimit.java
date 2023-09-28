import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class LicenseWithDiaryLimit extends LicenseWithTransactionLimit {
    private final int dailyTransactionLimit;
    private final Map<LocalDateTime, Integer> transactionsPerDay;

    public LicenseWithDiaryLimit(String userEmail, String urlService, int maxNumOfTransactions, int dailyTransactionLimit) {
        super(userEmail, urlService, maxNumOfTransactions);
        this.dailyTransactionLimit = dailyTransactionLimit;
        transactionsPerDay = new HashMap<>();
    }

    @Override
    public Transaction getAuthorizationOfTheService() {
        Transaction transaction = super.getAuthorizationOfTheService();
        LocalDateTime today = transaction.getCreatedAt().atStartOfDay();
        transactionsPerDay.put(today, transactionsPerDay.get(today) + 1);
        return transaction;
    }

    @Override
    protected boolean isApplicable() {
        LocalDateTime today = LocalDate.now().atStartOfDay();
        return transactionsPerDay.get(today) < dailyTransactionLimit && super.isApplicable();
    }
}
