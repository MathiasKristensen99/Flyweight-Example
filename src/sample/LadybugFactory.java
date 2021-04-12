package sample;

import javafx.scene.image.Image;

import java.util.HashMap;

public class LadybugFactory {
    private HashMap<Integer, Ladybug> lbCache = new HashMap<>();
    private String imageUrl;

    public LadybugFactory(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Ladybug create(int size) {
        Ladybug lb = lbCache.get(size);

        if (lb == null) {
            Image img = new Image(imageUrl, size, size, true, true);
            lb = new Ladybug(img, size);
            lbCache.put(size, lb);
        }
        return lb;
    }
}
