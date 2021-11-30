import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.Random;


public class gameScene extends Scene{
    private Camera camera;
    private StaticThings gauche;
    private StaticThings mid;
    private StaticThings droite;
    private hero Hero;
    private ArrayList<Foe> list;
    private Mechant mehdi;
    private StaticThings gameover;
    private Integer x=100;
    private Integer y=50;
    private Integer nb=200;
    private boolean u=false, go=false;
    private double m=5000000.0;
    private Integer score=0;
    private Label scorel;
    private Label scorel2;
    private double scoref;



    public gameScene(Group g) {
        super(g, 1300,400);
        camera= new Camera(0,10);
        gauche= new StaticThings(800,400,"desert.png");
        mid= new StaticThings(800,400,"desert.png");
        droite= new StaticThings(800,400,"desert.png");
        Hero = new hero(1000,0,"heros.png");
        mehdi = new Mechant(10,150,"heros.png");
        list = new ArrayList<Foe>();
        gameover=new StaticThings(800,800,"GAME_OVER.png");
        scorel = new Label("score :");
        scorel.setTextFill(Color.DARKGREEN);
        scorel.setLayoutX(600);
        scorel2 = new Label(score.toString());
        scorel2.setTextFill(Color.DARKGREEN);
        scorel2.setLayoutX(640);


        gameover.hide();
        gameover.getSprite().setX(400);

        mehdi.getSprite().setFitHeight(250);
        mehdi.getSprite().setFitWidth(200);

        g.getChildren().add(gauche.getSprite());
        g.getChildren().add(mid.getSprite());
        g.getChildren().add(droite.getSprite());
        g.getChildren().add(Hero.getSprite());
        g.getChildren().add(mehdi.getSprite());
        g.getChildren().add(scorel);
        g.getChildren().add(scorel2);
        g.getChildren().add(gameover.getSprite());
        creator();
        for(int i=0;i< list.size();i++){
            g.getChildren().add(list.get(i).getSprite());
        }
        render();
        this.setOnMouseClicked((event)->{
           Hero.jump();
        });

        timer.start();

    }

    void creator(){//créé les pieces

        for (int i = 0;i<nb;i++){
            list.add(new Foe(x+Math.random()*250,y+Math.random()*150,"piece1.png"));
            x=x+1200;
        }
    }


    void render(){//fait défiler à l'infini le décors
        double offset = camera.getX()% mid.getX();
        gauche.getSprite().setViewport(new Rectangle2D(offset,0,gauche.getX(), gauche.getY()));
        mid.getSprite().setViewport(new Rectangle2D(0,0,mid.getX(), mid.getY()));
        droite.getSprite().setViewport(new Rectangle2D(0,0,droite.getX(), droite.getY()));
        mid.getSprite().setX(mid.getX()-offset);
        droite.getSprite().setX(droite.getX()+800-offset);



    }
    AnimationTimer timer = new AnimationTimer() {
        private long lastUpdate=System.nanoTime();
        @Override
        public void handle(long time) {

            double timecam = time/m;
            long elapsedNanoSeconds = time - lastUpdate;
            double elapsedSeconds = elapsedNanoSeconds / 80000000.0;

            Hero.setDurée(Hero.getDurée()-0.00001);
            mehdi.setDurée(mehdi.getDurée()-0.00001);


           Hero.gethitbox(75,100);
           mehdi.gethitbox(300,300);
           //detecte la collision entre le méchant et le héro
           if(Hero.getSprite().getX()>mehdi.getX()+200){
               for(int i=0;i< list.size();i++){
                   //déplace les pièces
                   list.get(i).move();

               }

               Hero.update(elapsedSeconds);
               mehdi.updatem(elapsedSeconds);
               Hero.slowdown(elapsedSeconds);
               camera.setX(timecam);
               m=m-0.5;
               render();
               scoref++;
               //incrémente le score
               if (scoref%10==0){score=score+1;}

               scorel2.setText(score.toString());//affiche le score en jeu
               for(int i=0;i<list.size();i++){//détecte la collision du héro avec chaque pièce

                   if((Hero.getSprite().getX()<list.get(i).getSprite().getX()&&Hero.getSprite().getX()+75>list.get(i).getSprite().getX())&&(Hero.getSprite().getY()+100>list.get(i).getSprite().getY()&&Hero.getSprite().getY()-40<list.get(i).getSprite().getY())){

                       Hero.boost();


                       list.get(i).getSprite().setViewport(new Rectangle2D(300, 300, 1, 1));//fait disparaitre la pièce après avoir été attrapée





                   }


               }



           }
            else{
                gameover.show();
            }
        }
    };
}
