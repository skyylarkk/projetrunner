import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class hero extends AnimatedThings {


    private double x;
    private double y;
    private Image spritesheet = null;
    private ImageView sprite;
    private double t;
    private double g;
    private double b=5000;


    public hero(double x, double y, String fileName) {
        super(fileName, x, y, 75, 100, 85, 1, 6, 4, 5);



    }


    public void jump() {
        o = true;
    }

    public void slowdown(double t){
        g=getSprite().getX();

        g=g-t/b;

        getSprite().setX(g);
        b=b-10;
        System.out.println(b);
        if(b<1800){b=1800;}
        if(g>1000){g=1000;}



    }
    public void boost(){

            for (int i = 0; i < 30; i++) {


                g = g + 1;
                getSprite().setX(g);

            }

    }


}
