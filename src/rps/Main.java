package rps;

//Project imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import rps.gui.ConsoleApp;
import rps.gui.JavaFXApp;
import javafx.scene.Scene;

// import static javafx.application.Application.launch;

/**
 * Main class where we start
 *
 * @author smsj
 */
public class Main extends Application {

    private static FXMLLoader fxmlLoaderMain;

    /**
     * Main start
     * @param args
     */
    public static void main(String[] args)
    {
        launch(args);
        //Console version
        
        startRPSConsoleGame();
        //JavaFX version
        //startRPSJavaFXGame();
    }

    /**
     * Start a JavaFX version of the game
     */
    private void startRPSJavaFXGame() {
         Application.launch();
    }

    /**
     * Start a console version of the game
     */
    public static void startRPSConsoleGame() {
        new ConsoleApp().startGame();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}



