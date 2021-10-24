import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class gameScene extends Scene{
    private Camera camera;
    private StaticThings gauche;
    private StaticThings droite;

    public gameScene(Group g) {
        super(g, 600,300);
        camera= new Camera(10,10);
        gauche= new StaticThings(100,100,"desert.png");
        droite= new StaticThings(100,100,"desert.png");
        //render();
    }
   /* void render(){
        double offset = camera
    }*/
}
