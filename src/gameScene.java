import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class gameScene extends Scene{
    private Camera camera;
    private StaticThings gauche;
    private StaticThings droite;
    private hero Hero;

    public gameScene(Group g) {
        super(g, 600,400);
        camera= new Camera(0,10);
        gauche= new StaticThings(800,400,"desert.png");
        droite= new StaticThings(800,400,"desert.png");
        Hero = new hero(10,250,"heros.png");
        g.getChildren().add(gauche.getSprite());
        g.getChildren().add(droite.getSprite());
        g.getChildren().add(Hero.getSprite());
        render();
        this.setOnMouseClicked((event)->{
           Hero.jump();
        });

        //hero.update(System.nanoTime());
        timer.start();
    }
    void render(){
        double offset = camera.getX()% droite.getX();
        gauche.getSprite().setViewport(new Rectangle2D(0,0,gauche.getX(), gauche.getY()));
        droite.getSprite().setViewport(new Rectangle2D(offset,0,droite.getX()-offset, droite.getY()));
        gauche.getSprite().setX(gauche.getX()-offset);

    }
    AnimationTimer timer = new AnimationTimer() {
        private long lastUpdate=System.nanoTime();
        @Override
        public void handle(long time) {

            double timecam = time/ 5000000.0;
            long elapsedNanoSeconds = time - lastUpdate;
            double elapsedSeconds = elapsedNanoSeconds / 80000000.0;
            Hero.update(elapsedSeconds);
            camera.setX(timecam);





            /*double a =droite.getX()-camera.getX()% gauche.getX();
            double b =droite.getX()-camera.getX()% gauche.getX();
            double offset = camera.getX()% gauche.getX();*/

           // gameScene.update(time);
            render();
        }
    };
}
