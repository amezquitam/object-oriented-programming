package library;

import java.time.LocalDate;

public interface ILibraryManager {
    boolean consult(String ID, LocalDate date, String DNI);
    boolean lend(String ID, LocalDate date, String DNI);
}
