package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Canvas canvas;
    GraphicsContext gc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gc = canvas.getGraphicsContext2D();
    }

    public void handleSelectNoFly(ActionEvent actionEvent) {
        long start = System.nanoTime();
        Random rand = new Random();

        for (int i = 0; i < 100; i++) {
            int size = getRandSize(rand);
            Image image = new Image("ladybug.png", size, size, true, true);
            gc.drawImage(image, rand.nextInt((int) canvas.getWidth()), rand.nextInt((int) canvas.getHeight()));
        }
        long end = System.nanoTime();
        System.out.println("Time " + (end - start) / 1_000_000 + " ms");
    }

    public void handleSelectFly(ActionEvent actionEvent) {
        long start = System.nanoTime();
        Random rand = new Random();
        LadybugFactory ladybugFactory = new LadybugFactory("ladybug.png");
        for (int i = 0; i < 1000; i++) {
            int size = getRandSize(rand);
            Ladybug lb = ladybugFactory.create(size);
            gc.drawImage(lb.getImage(), rand.nextInt((int) canvas.getWidth()), rand.nextInt((int) canvas.getHeight()));
        }
        long end = System.nanoTime();
        System.out.println("Time " + (end - start) / 1_000_000 + " ms");
    }

    private int getRandSize(Random rand) {
        return (rand.nextInt(2)+1) * 15;
    }
}
