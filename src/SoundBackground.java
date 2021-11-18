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
            mediaPlayer.setCycleCount(3);
            mediaPlayer.setOnReady(() -> {
                mediaPlayer.play();
                mediaPlayer.setOnEndOfMedia(() -> {
                    mediaPlayer.play();
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
