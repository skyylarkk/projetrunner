import javafx.application.Application;
import javafx.geometry.Rectangle2D;
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
    private hero Hero;

    public gameScene(Group g) {
        super(g, 600,400);
        camera= new Camera(200,10);
        gauche= new StaticThings(800,400,"desert.png");
        droite= new StaticThings(800,400,"desert.png");
        Hero = new hero(10,250,"heros.png");
        g.getChildren().add(gauche.getSprite());
        g.getChildren().add(droite.getSprite());
        g.getChildren().add(hero.getSprite());
        render();
    }
    void render(){
        double offset = camera.getX()% gauche.getX();
        gauche.getSprite().setViewport(new Rectangle2D(0,0,gauche.getX()-offset, gauche.getY()));
        droite.getSprite().setViewport(new Rectangle2D(offset,0,droite.getX()-offset, droite.getY()));
        System.out.println(gauche.getX()-offset);
    }
}
