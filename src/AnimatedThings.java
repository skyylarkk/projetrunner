import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.lang.*;
import java.util.ArrayList;

abstract public class AnimatedThings {
    private ImageView sprite;
    //public ImageView sprite;
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
    private double lasttime=0;
    private double t;
    protected boolean o;


    protected double a=9.83,v,p,p2;




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

   public ImageView getSprite() {
        return sprite;
    }


    public void update(double time) {

        index = (int) ((time % (maxindex * durée)) / durée);

        if (o == true || p < 250) {
            t = time - lasttime;
            v = a * t - 100;
            p = (1 / 2) * a * (t) * (t) + v * (t) + 249;
            sprite.setY(p);
            //System.out.println( p+"   "+t);
            o = false;
            if (0 > p2 - p) {
                sprite.setViewport(new Rectangle2D(firstx + offset, 160, hauteur, largeur));

            }
            if (0 < p2 - p) {
                sprite.setViewport(new Rectangle2D(firstx, 160, hauteur, largeur));

            }
            p2 = p;

        } else {
            lasttime = time;
            sprite.setViewport(new Rectangle2D(firstx + (index * offset), firsty, hauteur, largeur));
        }

        if (p > 250) {

            p = 250;
            v = 0;
            sprite.setY(p);


        }






    }


    public void updatem(double time) {

        index = (int) ((time % (maxindex * durée)) / durée);
        sprite.setViewport(new Rectangle2D(firstx + (index * offset), firsty, hauteur, largeur));

    }

    public Rectangle2D gethitbox(int lo, int lar){
        return new Rectangle2D(getX(),getY(),lo,lar);
    }



    public void setY(double y) {
        this.y = y;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {this.x = x;}

    public double getX() {return x;}

    public double getDurée() {
        return durée;
    }

    public void setDurée(double durée) {
        this.durée = durée;
    }

}
