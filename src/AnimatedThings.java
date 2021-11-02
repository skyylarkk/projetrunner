import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

abstract public class AnimatedThings {
    private static ImageView sprite;
    private double x;
    private double y;
    private Integer maxindex;
    private Image spritesheet;
    //private ImageView sprite;
    private Integer hauteur;
    private Integer largeur;
    private Integer offset;
    private double durée;
    private Integer index;
    private Integer firstx;
    private Integer firsty;


    public AnimatedThings(String filename, double x, double y, Integer hauteur, Integer largeur, Integer offset, double durée, Integer maxindex, Integer firstx, Integer firsty) {
        this.x = x;
        this.y = y;
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.offset = offset;
        this.durée = durée;
        this.maxindex = maxindex;
        this.firstx = firstx;
        this.firsty = firsty;
        spritesheet = new Image(filename);
        sprite = new ImageView(spritesheet);
        sprite.setViewport(new Rectangle2D(this.firstx, this.firsty, this.hauteur, this.largeur));
        sprite.setX(x);
        sprite.setY(y);
    }
    public static ImageView getSprite() {
        return sprite;
    }

    public void update(double time){
        index= (int)((time%(maxindex*durée))/durée);
        sprite.setViewport(new Rectangle2D(firstx+(index*offset),firsty,hauteur, largeur));
    }

}
