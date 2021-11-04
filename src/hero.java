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
    private  Image spritesheet=null;
    private  ImageView sprite;


    public hero  (double x, double y, String fileName){
        super(fileName,x , y,75,100,85,1,6,4,5);

        /*this.x=x;
        this.y=y;
        spritesheet=new Image(fileName);
        sprite = new ImageView(spritesheet);
        sprite.setViewport(new Rectangle2D(10,10,70,90));
        sprite.setX(x);
        sprite.setY(y);*/

    }


    public void jump(){
        o=true;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

   /*public ImageView getSprite() {
        return sprite;
    }*/

}
