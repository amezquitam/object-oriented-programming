package domain;

public class LicenseWithTransactionLimit extends License {
    private final int maxNumOfTransactions;

    public LicenseWithTransactionLimit(String userEmail, String urlService, int maxNumOfTransactions) {
        super(userEmail, urlService);
        this.maxNumOfTransactions = maxNumOfTransactions;
    }

    @Override
    protected boolean isNotApplicable() {
        return getNumOfRemainingTransactions() <= 0;
    }

    public int getMaxNumOfTransactions() {
        return maxNumOfTransactions;
    }

    @Override
    public String toString() {
        return "\nLicenseWithTransactionLimit {\n" +
                "maxNumOfTransactions=" + maxNumOfTransactions + '\n' +
                "License=" + super.toString() + '\n' +
                '}';
    }

    public int getNumOfRemainingTransactions() {
        return getMaxNumOfTransactions() - getNumOfTransactions();
    }
}
