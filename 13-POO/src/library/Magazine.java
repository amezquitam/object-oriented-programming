package library;

import java.util.List;

public class Magazine extends Book {
    private int volume;
    private int number;
    private int departureMonth;

    public Magazine(String title, List<String> authors, String editorial, int yearOfPublication, int volume, int number, int departureMonth) {
        super(title, authors, editorial, yearOfPublication);
        this.volume = volume;
        this.number = number;
        this.departureMonth = departureMonth;
    }

    @Override
    public boolean canBeLent() {
        return true;
    }

}
