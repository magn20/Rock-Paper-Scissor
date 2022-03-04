package rps.gui;

// Java imports

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.File;
import java.net.URISyntaxException;

/**
 * JavaFX implementation of the RPS game
 *
 * @author smsj
 */
public class JavaFXApp extends Application {
    private static FXMLLoader fxmlLoaderMain;

    public static void launch() {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/rps/gui/view/GameView.fxml"));

        primaryStage.setTitle("Rock Paper Scissor");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();



        Media sound = new Media(new File("src/rps/resource/The Worst Song Ever.mp3").toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.play();
    }

}
