import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Foe extends StaticThings {
    private double x;
    private double y;
    private double v=10;
    private  Image spritesheet=null;
    private  ImageView sprite;
    private boolean o=false;

    public Foe  (double x, double y, String fileName){
        super(x,y,fileName);

        getSprite().setViewport(new Rectangle2D(2, 3, 40, 40));
        getSprite().setX(x);
        getSprite().setY(y);

        /*this.x=x;
        this.y=y;
        spritesheet=new Image(fileName);
        sprite = new ImageView(spritesheet);
        sprite.setViewport(new Rectangle2D(10,10,70,90));
        sprite.setX(x);
        sprite.setY(y);*/

    }

        public void move(){
        x=getSprite().getX();
        x=x-v;
        getSprite().setX(x);
        v=v+0.002;
        System.out.println(v);
        if (v>22){
            v=22;
        }
        }
    public void used(){
        o=true;
    }
    public boolean isO() {
        return o;
    }

    public void setSpritesheet(Image spritesheet) {
        this.spritesheet = spritesheet;
    }

    public void setSprite(ImageView sprite) {
        this.sprite = sprite;
    }



}
