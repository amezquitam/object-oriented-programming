package museum;

public class Sculpture extends ArtisticWork {
    private String material;
    private Float height;

    public String getMaterial() {
        return material;
    }

    public Float getHeight() {
        return height;
    }

    public Sculpture(String title, Integer inventoryNumber, Artist author, Integer yearWasMade, String material, Float height) {
        super(title, inventoryNumber, author, yearWasMade);
        this.material = material;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Sculpture:" +
                "\ttitle: " + getTitle() + '\n' +
                "\tinventoryNumber: " + getInventoryNumber() + '\n' +
                "\tauthor: " + getAuthor() + '\n' +
                "\tyearWasMade: " + getYearWasMade() + '\n' +
                "\tmaterial: " + material + '\n' +
                "\theight: " + height + '\n';
    }
}
