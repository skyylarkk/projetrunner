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
    private ImageView sprite;
    private Image image;



    public StaticThings(double x, double y, String filename) {
        this.x = x;
        this.y = y;
        image = new Image(filename);
        sprite = new ImageView(image);
    }
    public ImageView getSprite() {
        return sprite;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void show(){this.sprite.setImage(image);}
    public void hide(){this.sprite.setImage(null);}
}
