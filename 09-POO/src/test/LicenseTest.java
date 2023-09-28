package test;

import domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class LicenseTest {

    @Test
    void getAuthorizationOfTheService() {
        String service = "http://api.um.es/disco/v1/";
        License[] licenses = new License[] {
                new LicenseWithTemporaryLimit("juan@um.es", service, 1),
                new LicenseWithTransactionLimit("pepe@um.es", service, 3),
                new LicenseWithDiaryLimit("paco@um.es", service, 4, 1),
        };

        System.out.println("Licenses (First time):");

        System.out.println(Arrays.toString(licenses));

        System.out.println("\n\nRemaining transaction today:");

        for (License _license: licenses) {
            if (_license instanceof LicenseWithDiaryLimit license) {
                System.out.println("Remaining transactions for today: " + license.getRemainingTransactionForToday());
                //license.revoke();
            }
        }

        System.out.println("\n\nTransactions:");

        for (License license: licenses) {
            Transaction transaction = license.getAuthorizationToTheService();
            if (transaction != null) System.out.println(transaction);
            else System.out.println("Not authorized");
        }

        System.out.println("Licenses (Second time):");

        System.out.println(Arrays.toString(licenses));

        List<License> copies = new LinkedList<>();
        System.out.println("Licenses (Second time):");

        for (License license : licenses) {
            copies.add(license.clone());
        }

        System.out.println("Licenses (Clones):");

        for (License license : copies) {
            System.out.println(license);
        }

    }
}