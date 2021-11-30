import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.lang.Thread;
import javafx.stage.*;


public class SoundBackground extends Application implements Runnable {
    final File file = new File("./music/bit rush.mp3");
    final Media media = new Media(file.toURI().toString());
    final MediaPlayer mediaPlayer = new MediaPlayer(media);
    @Override
    public void run() {
        try{
            mediaPlayer.setCycleCount(3);//se prépare à jouer le média 3 fois
            mediaPlayer.setOnReady(() -> {//une fois que le média est pret
                mediaPlayer.play();//joue le média
                mediaPlayer.setOnEndOfMedia(() -> {//lorsque le média est fini
                    mediaPlayer.play();//rejoue le média
                });
            });
        }
        catch (Exception e)
        { System.out.println("cassé chef");
            e.printStackTrace();}
    }

    public void start(Stage theStage)
    {
        this.run();
    }
}
