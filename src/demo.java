    // add any usefull package line


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.media.MediaView;

import java.nio.file.Paths;


    public class demo extends Application{
        private static final Image SCENERY = new Image("desert.png", 600, 400, true, true);
        final private ImageView ImageViewSceneryLeft = new ImageView(SCENERY);
        SoundBackground music = new SoundBackground();


        public void start(Stage primaryStage){

            /*Media pick = new Media("bit rush.mp3"); // replace this with your own audio file
            MediaPlayer player = new MediaPlayer(pick);*/



            primaryStage.setTitle("Demo");
            Group root = new Group();
            gameScene scene = new gameScene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            music.run();



        }

        /*MediaPlayer mediaplayer;
        public void music(){
            String s = "bit rush.mp3";
            Media h = new Media(Paths.get(s).toUri().toString());
            mediaplayer= new MediaPlayer(h);
            mediaplayer.play();
        }*/
        public static void main(String[] args) {
            launch(args);
            // write your code here
        }
    }

