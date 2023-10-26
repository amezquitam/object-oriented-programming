package museum;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {
    List<ArtisticWork> artisticWorks;

    public Catalogue() {
        artisticWorks = new ArrayList<>();
    }

    public boolean addWork(ArtisticWork work) {
        return artisticWorks.add(work);
    }

    public boolean removeWork(Integer numInInventory) {
        return artisticWorks.removeIf(work -> work.getInventoryNumber().equals(numInInventory));
    }

    public ArtisticWork findWork(Integer numInInventory) {
        return artisticWorks.stream()
                .filter(work -> work.getInventoryNumber().equals(numInInventory))
                .findAny().orElse(null);
    }

    public float surface() {
        return artisticWorks.stream()
                .map(work -> {
                    if (work instanceof Painting painting)
                        return painting.getHeight() * painting.getWidth();
                    else
                        return 0.0F;
                }).reduce(Float::sum).orElse(0.0F);
    }

    public int getHighestSculpture() {
        return artisticWorks.stream()
                .max((a, b) -> {
                    if (a instanceof Sculpture A && b instanceof Sculpture B)
                        return (int) (A.getHeight() - B.getHeight());
                    else return 0;
                }).get().getInventoryNumber();
    }
}
