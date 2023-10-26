package library;

import java.util.List;

public class Book implements Resource {
    private String title;
    private List<String> authors;
    private String editorial;
    private int yearOfPublication;

    public Book(String title, List<String> authors, String editorial, int yearOfPublication) {
        this.title = title;
        this.authors = authors;
        this.editorial = editorial;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public boolean canBeLent() {
        return true;
    }

    @Override
    public boolean canBeConsulted() {
        return true;
    }
}
