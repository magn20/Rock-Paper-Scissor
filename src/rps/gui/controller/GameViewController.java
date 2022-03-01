package rps.gui.controller;

// Java imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author smsj
 */
public class GameViewController implements Initializable {

    @FXML
    public Label lblUsername;

    @FXML
    public Label lblInsertedUsername;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void OnPlayRock(MouseEvent mouseEvent) {
    }

    public void OnPlayPaper(MouseEvent mouseEvent) {
    }

    public void OnPlayScissor(MouseEvent mouseEvent) {
    }

    public void onSetName(ActionEvent actionEvent) throws IOException {
        if (lblUsername != null) {
            // lblUsername.getText() &&
            lblInsertedUsername.setText(lblUsername.getText());

            // lblInsertedUsername.setText() == lblUsername.getText();
        }
    }
}
