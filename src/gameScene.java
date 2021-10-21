import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class gameScene extends Scene{
    Camera camera;

    public gameScene(Group g) {
        super(g, 600,300);
        camera= new Camera(10,10);
        //render();
    }
   /* void render(){
        double offset = camera
    }*/
}
