package library;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryManager implements ILibraryManager {
    List<Resource> resources;

    public LibraryManager() {
        this.resources = new ArrayList<>();
    }

    void addResource(Resource resource) {
        resources.add(resource);
    }

    @Override
    public boolean consult(String ID, LocalDate date, String DNI) {
        return false;
    }

    @Override
    public boolean lend(String ID, LocalDate date, String DNI) {
        return false;
    }
}
