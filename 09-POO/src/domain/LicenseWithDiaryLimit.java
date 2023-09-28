package domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class LicenseWithDiaryLimit extends LicenseWithTransactionLimit {
    private final int dailyTransactionLimit;
    private Map<LocalDateTime, Integer> transactionsPerDay;

    public LicenseWithDiaryLimit(String userEmail, String urlService, int maxNumOfTransactions, int dailyTransactionLimit) {
        super(userEmail, urlService, maxNumOfTransactions);
        this.dailyTransactionLimit = dailyTransactionLimit;
        transactionsPerDay = new HashMap<>();
    }

    @Override
    public Transaction getAuthorizationToTheService() {
        Transaction transaction = super.getAuthorizationToTheService();
        if (transaction == null) return null;
        LocalDateTime today = transaction.getCreatedAt().atStartOfDay();
        transactionsPerDay.put(today, getTransactionsInDay(today) + 1);
        return transaction;
    }

    @Override
    protected boolean isNotApplicable() {
        LocalDateTime today = LocalDate.now().atStartOfDay();
        return getTransactionsInDay(today) >= dailyTransactionLimit || super.isNotApplicable();
    }

    public int getRemainingTransactionForToday() {
        LocalDateTime today = LocalDate.now().atStartOfDay();
        return dailyTransactionLimit - getTransactionsInDay(today);
    }

    private int getTransactionsInDay(LocalDateTime day) {
        Integer dayTransactions = transactionsPerDay.get(day);
        return dayTransactions != null ? dayTransactions : 0;
    }

    @Override
    public License clone() {
        LicenseWithDiaryLimit license = (LicenseWithDiaryLimit) super.clone();
        license.transactionsPerDay = Map.copyOf(license.transactionsPerDay);
        return license;
    }

    @Override
    public String toString() {
        return "\nLicenseWithDiaryLimit{" + '\n' +
                "dailyTransactionLimit=" + dailyTransactionLimit + '\n' +
                "transactionsPerDay=" + transactionsPerDay + '\n' +
                "License=" + super.toString() + '\n' +
                "}";
    }
}
