    // add any usefull package line


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


    public class demo extends Application{
        private static final Image SCENERY = new Image("desert.png", 600, 400, true, true);
        final private ImageView ImageViewSceneryLeft = new ImageView(SCENERY);


        public void start(Stage primaryStage){
            primaryStage.setTitle("Demo");
            Group root = new Group();
            gameScene scene = new gameScene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            //root.getChildren().add(ImageViewSceneryLeft);
            //root.getChildren().add(Hero.getSprite());
        }
        public static void main(String[] args) {
            launch(args);
            // write your code here
        }
    }

