import java.time.LocalDate;

/**
 * An elector represents a person who can vote in a consultation. The properties that
 * Characterize a voter are the dni, the name and the date of birth. All properties are
 * They are established at construction and cannot change once established. All of them can be
 * Consult. Implements the toString method to be able to display all the properties of an
 * elector.
 */
public class Voter {
    final private String DNI;
    final private String name;
    final private LocalDate dateOfBirth;

    public Voter(String DNI, String name, LocalDate dateOfBirth) {
        this.DNI = DNI;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getDNI() {
        return DNI;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Elector{" +
                "ID='" + DNI + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
