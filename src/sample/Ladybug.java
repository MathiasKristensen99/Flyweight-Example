package sample;

import javafx.scene.image.Image;

public class Ladybug {
    private Image image;
    private int size;

    public Ladybug(Image image, int size) {
        this.image = image;
        this.size = size;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
