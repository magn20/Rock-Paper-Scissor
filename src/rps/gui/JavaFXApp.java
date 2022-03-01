package rps.gui;

// Java imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import rps.gui.ConsoleApp;
import rps.gui.JavaFXApp;
import javafx.scene.Scene;

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
        fxmlLoaderMain = new FXMLLoader(getClass().getResource("./gui/view/GameView.fxml"));
        primaryStage.centerOnScreen();
        Scene scene = new Scene(fxmlLoaderMain.load());
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rock, Paper, Scissor");
        primaryStage.show();
    }
}
