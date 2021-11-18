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
        private static final Image SCENERY = new Image("Capture.PNG", 1300, 300, true, true);
        final private ImageView ImageViewSceneryLeft = new ImageView(SCENERY);
        SoundBackground music = new SoundBackground();




        public void start(Stage primaryStage){

            primaryStage.setTitle("Demo");
            Group root = new Group();
            Group root2 = new Group();
            gameScene scene = new gameScene(root);
            Scene scene2 = new Scene(root2);
            root2.getChildren().add(ImageViewSceneryLeft);
            primaryStage.setScene(scene2);
            scene2.setOnMouseClicked((event)->{
                primaryStage.setScene(scene);
            });
            primaryStage.show();

                music.run();




        }



        public static void main(String[] args) {
            launch(args);
            // write your code here
        }
    }

