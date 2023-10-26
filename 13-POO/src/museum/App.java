package museum;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Catalogue catalogue = new Catalogue();
        Artist davinci = new Artist("Davinci", "Nose", LocalDate.of(1812, 7, 15), LocalDate.of(1874, 2, 12));

        catalogue.addWork(new Sculpture("SCA", 9, davinci, 1845, "Wood", 1.2F));
        catalogue.addWork(new Sculpture("SCB", 4, davinci, 1845, "Wood", 1.4F));
        catalogue.addWork(new Sculpture("SCC", 3, davinci, 1845, "Wood", 1.8F));
        catalogue.addWork(new Painting("PIA", 1, davinci, 1846, 1.15F, 0.77F, "Stick"));
        catalogue.addWork(new Painting("PIB", 2, davinci, 1846, 1.35F, 0.9F, "Stick"));
        catalogue.addWork(new Painting("PIC", 5, davinci, 1846, 1.05F, 0.75F, "Stick"));
        catalogue.addWork(new Painting("PID", 6, davinci, 1846, 0.45F, 0.8F, "Stick"));

        System.out.println(catalogue.getHighestSculpture());
        System.out.println(catalogue.surface());
    }

}
