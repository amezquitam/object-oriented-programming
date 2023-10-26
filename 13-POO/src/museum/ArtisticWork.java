package museum;

import java.util.Objects;

public class ArtisticWork {
    private String title;
    private Integer inventoryNumber;
    private Artist author;
    private Integer yearWasMade;

    public ArtisticWork(String title, Integer inventoryNumber, Artist author, Integer yearWasMade) {
        this.title = title;
        this.inventoryNumber = inventoryNumber;
        this.author = author;
        this.yearWasMade = yearWasMade;
    }

    public String getTitle() {
        return title;
    }

    public Integer getInventoryNumber() {
        return inventoryNumber;
    }

    public Artist getAuthor() {
        return author;
    }

    public Integer getYearWasMade() {
        return yearWasMade;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtisticWork that = (ArtisticWork) o;
        return Objects.equals(inventoryNumber, that.inventoryNumber);
    }

    @Override
    public String toString() {
        return "ArtisticWork:\n" +
                "\ttitle: " + title + '\n' +
                "\tinventoryNumber: " + inventoryNumber + '\n' +
                "\tauthor: " + author + '\n' +
                "\tyearWasMade: " + yearWasMade + '\n';
    }

    public void show() {
        System.out.println(this);
    }
}
