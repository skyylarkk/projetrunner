import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class StaticThings {
    private double x;
    private double y;
    private static ImageView sprite;

    public StaticThings(double x, double y, String filename) {
        this.x = x;
        this.y = y;
        Image image = new Image(filename);
        sprite = new ImageView(image);
    }
}
