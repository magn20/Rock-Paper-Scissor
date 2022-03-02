package rps;

//Project imports
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import rps.gui.ConsoleApp;
import rps.gui.JavaFXApp;

/**
 * Main class where we start
 *
 * @author smsj
 */
public class Main {
// helllo

    /**
     * Main start
     * @param args
     */
    public static void main(String[] args)
    {
        //Console version
        //startRPSConsoleGame();

        //JavaFX version
        startRPSJavaFXGame();


    }

    /**
     * Start a JavaFX version of the game
     */
    private static void startRPSJavaFXGame() {
        JavaFXApp.launch();
    }

    /**
     * Start a console version of the game
     */
    public static void startRPSConsoleGame() {
        new ConsoleApp().startGame();
    }
}



