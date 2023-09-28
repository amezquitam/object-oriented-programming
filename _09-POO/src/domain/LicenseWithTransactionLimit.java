public class LicenseWithTransactionLimit extends License {
    private final int maxNumOfTransactions;

    public LicenseWithTransactionLimit(String userEmail, String urlService, int maxNumOfTransactions) {
        super(userEmail, urlService);
        this.maxNumOfTransactions = maxNumOfTransactions;
    }

    @Override
    protected boolean isApplicable() {
        return getNumOfRemainingTransactions() > 0;
    }

    public int getMaxNumOfTransactions() {
        return maxNumOfTransactions;
    }

    public int getNumOfRemainingTransactions() {
        return getMaxNumOfTransactions() - getNumOfTransactions();
    }
}
