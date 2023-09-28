package domain;

import java.time.LocalDate;

public class LicenseWithTemporaryLimit extends License {
    private LocalDate expirationDate;
    public LicenseWithTemporaryLimit(String userEmail, String urlService, LocalDate expirationDate) {
        super(userEmail, urlService);
        this.expirationDate = expirationDate;
    }

    public LicenseWithTemporaryLimit(String userEmail, String urlService, int durationInMonths) {
        this(userEmail, urlService, LocalDate.now().plusMonths(durationInMonths));
    }

    public LicenseWithTemporaryLimit(String userEmail, String urlService) {
        this(userEmail, urlService, 3);
    }

    @Override
    protected boolean isNotApplicable() {
        return expired();
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public boolean expired() {
        return expirationDate.isAfter(LocalDate.now());
    }

    public void extendExpirationDate(int additionalMonths) {
        if (additionalMonths > 0)
            this.expirationDate = this.expirationDate.plusMonths(additionalMonths);
    }

    @Override
    public String toString() {
        return "\nLicenseWithTemporaryLimit {\n" +
                "expirationDate=" + expirationDate + '\n' +
                "License=" + super.toString() + '\n' +
                '}';
    }
}
