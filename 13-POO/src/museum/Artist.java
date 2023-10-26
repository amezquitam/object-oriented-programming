package museum;

import java.time.LocalDate;

public class Artist {
    private String name;
    private String placeOfBirth;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;

    public Artist(String name, String placeOfBirth, LocalDate dateOfBirth, LocalDate dateOfDeath) {
        this.name = name;
        this.placeOfBirth = placeOfBirth;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }
}
