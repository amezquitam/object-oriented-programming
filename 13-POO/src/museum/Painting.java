package museum;

public class Painting extends ArtisticWork {
    private float width;
    private float height;
    private String support;

    @Override
    public String toString() {
        return "Painting:" +
                "\ttitle: " + getTitle() + '\n' +
                "\tinventoryNumber: " + getInventoryNumber() + '\n' +
                "\tauthor: " + getAuthor() + '\n' +
                "\tyearWasMade: " + getYearWasMade() + '\n' +
                "\twidth: " + width + '\n' +
                "\theight: " + height + '\n' +
                "\tsupport: " + support + '\n';
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public String getSupport() {
        return support;
    }

    public Painting(String title, Integer inventoryNumber, Artist author, Integer yearWasMade, float width, float height, String support) {
        super(title, inventoryNumber, author, yearWasMade);
        this.width = width;
        this.height = height;
        this.support = support;
    }
}
