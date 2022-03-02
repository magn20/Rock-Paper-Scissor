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
        Parent root = FXMLLoader.load(getClass().getResource("/rps/gui/view/GameView.fxml"));
        
        primaryStage.setTitle("Rock Paper Scissor");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
