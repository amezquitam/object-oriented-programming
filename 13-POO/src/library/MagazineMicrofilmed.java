package library;

import java.util.List;

public class MagazineMicrofilmed extends Magazine {
    public MagazineMicrofilmed(String title, List<String> authors, String editorial, int yearOfPublication, int volume, int number, int departureMonth) {
        super(title, authors, editorial, yearOfPublication, volume, number, departureMonth);
    }

    @Override
    public boolean canBeLent() {
        return false;
    }
}
