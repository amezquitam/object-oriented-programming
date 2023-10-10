import java.time.LocalDate;

/**
 * An elector represents a person who can vote in a consultation. The properties that
 * Characterize a voter are the ID, the name and the date of birth. All properties are
 * They are established at construction and cannot change once established. All of them can be
 * Consult. Implements the toString method to be able to display all the properties of a
 * elector.
 */
public class Elector {
    final private String ID;
    final private String name;
    final private LocalDate dateOfBirth;

    public Elector(String ID, String name, LocalDate dateOfBirth) {
        this.ID = ID;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getID() {
        return ID;
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
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
