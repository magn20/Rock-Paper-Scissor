package rps.gui.controller;

// Java imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import rps.bll.game.GameManager;
import rps.bll.game.Move;
import rps.bll.game.Result;
import rps.bll.game.ResultType;
import rps.bll.player.IPlayer;
import rps.bll.player.Player;
import rps.bll.player.PlayerType;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 *
 * @author smsj
 */
public class GameViewController implements Initializable {


    @FXML
    private Label lblWhoWon;

    @FXML
    private ImageView imgCombat;
    @FXML
    private Label lblRoundNumber;
    @FXML
    private Label lblButWins;
    @FXML
    private Label lblTies;
    @FXML
    private Label lblPlayerWins;
    @FXML
    private Label lblInsertedUsername;
    @FXML
    private TextField lblUsername;
    @FXML
    private ImageView RockBtn;
    @FXML
    private ImageView PaperBtn;
    @FXML
    private ImageView ScissorBtn;

    private GameManager ge;
    private String playerMove = "";
    private boolean gameStarted;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gameStarted = false;
    }

    public void OnPlayRock(MouseEvent mouseEvent) {
        if (gameStarted){
            playerMove = "Rock";
            startGame();
        }
    }

    public void OnPlayPaper(MouseEvent mouseEvent) {
        if (gameStarted){
            playerMove = "Paper";
            startGame();
        }
    }

    public void OnPlayScissor(MouseEvent mouseEvent) {
        if (gameStarted){
            playerMove = "Scissor";
            startGame();
        }

    }

    public void onSetName(ActionEvent actionEvent) throws IOException {
        if (lblUsername != null) {
            // lblUsername.getText() &&
            lblInsertedUsername.setText(lblUsername.getText());

            // lblInsertedUsername.setText() == lblUsername.getText();

            String playerName = lblInsertedUsername.getText();

            gameStarted = true;
            IPlayer human = new Player(playerName, PlayerType.Human);
            IPlayer bot = new Player("Hans", PlayerType.AI);

            ge = new GameManager(human, bot);

        }
    }


    public void startGame(){

        playerMove = getPlayerMove();

        ge.playRound(Move.valueOf(playerMove));

        ge.getGameState().getHistoricResults().forEach((result) -> {
            System.out.println(getResultAsString(result));
        });

        lblRoundNumber.setText("Round: " + String.valueOf(ge.getGameState().getRoundNumber()));


        ArrayList<Result> resultsList = (ArrayList<Result>) ge.getGameState().getHistoricResults();
        Result result = resultsList.get(resultsList.size() - 1);
        whoWon(result);
    }


    public void whoWon(Result result){
        String statusText = result.getType() == ResultType.Win ? "wins over " : "ties ";
        lblWhoWon.setText(result.getWinnerPlayer().getPlayerName() +
                " (" + result.getWinnerMove() + ") " +
                statusText + result.getLoserPlayer().getPlayerName() +
                " (" + result.getLoserMove() + ")!");
    }


    public String getResultAsString(Result result) {
        String statusText = result.getType() == ResultType.Win ? "wins over " : "ties ";

        return "Round #" + result.getRoundNumber() + ":" +
                result.getWinnerPlayer().getPlayerName() +
                " (" + result.getWinnerMove() + ") " +
                statusText + result.getLoserPlayer().getPlayerName() +
                " (" + result.getLoserMove() + ")!";
    }



        private String getPlayerMove() {
            return  playerMove;

        }
    }
