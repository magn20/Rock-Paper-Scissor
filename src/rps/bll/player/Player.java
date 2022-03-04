package rps.bll.player;

//Project imports
import rps.bll.game.IGameState;
import rps.bll.game.Move;
import rps.bll.game.Result;

//Java imports
import java.util.ArrayList;

/**
 * Example implementation of a player.
 *
 * @author smsj
 */
public class Player implements IPlayer {

    private String name;
    private PlayerType type;

    /**
     * @param name
     */
    public Player(String name, PlayerType type) {
        this.name = name;
        this.type = type;
    }


    @Override
    public String getPlayerName() {
        return name;
    }


    @Override
    public PlayerType getPlayerType() {
        return type;
    }


    ArrayList<Move> playerMoves = new ArrayList<>();

    /**
     * Decides the next move for the bot...
     * @param state Contains the current game state including historic moves/results
     * @return Next move
     */
    @Override
   //  public Move doMove(IGameState state) {
        //Historic data to analyze and decide next move...
       // ArrayList<Result> results = (ArrayList<Result>) state.getHistoricResults();

        //Implement better AI here...
        public Move doMove(IGameState state) {


        playerMoves = new ArrayList<>();
        state.getHistoricResults().forEach((result) -> {
            if(result.getWinnerPlayer().getPlayerType() == (PlayerType.AI)){
                playerMoves.add(result.getLoserMove());
            }else {
                playerMoves.add(result.getWinnerMove());
            }
        });


        ArrayList<Move> possibleMoves = new ArrayList<>();
        possibleMoves.add(Move.Rock);
        possibleMoves.add(Move.Paper);
        possibleMoves.add(Move.Scissor);
        int count = 1;
        ArrayList<Move> rightMoves = new ArrayList<>();

        if (!playerMoves.isEmpty()){
            for (Move move: possibleMoves) {
                if (playerMoves.get(playerMoves.size() - 1).equals(move)){
                    for (Move testMove: playerMoves) {
                        if (testMove.equals(move))
                            if (playerMoves.size() > count ){
                                rightMoves.add(playerMoves.get(count));
                            }

                        count++;
                    }
                }
            }
        }

        int rockMoves = 0;
        int paperMoves = 0;
        int  scissorMoves = 0;
        for (Move ourMove: rightMoves) {
            if (ourMove.equals(Move.Rock)) rockMoves++;
            if (ourMove.equals(Move.Paper)) paperMoves++;
            if (ourMove.equals(Move.Scissor)) scissorMoves++;
        }
        if (rockMoves > paperMoves && rockMoves > scissorMoves) return Move.Paper;
        if (paperMoves > rockMoves && paperMoves > scissorMoves) return Move.Scissor;
        if (scissorMoves > rockMoves && scissorMoves > paperMoves) return Move.Rock;



        System.out.println("The Bot just played Random");
















        double random = Math.random() * 3;
            int randomNumber = (int) random;
            switch (randomNumber) {
                case 0:
                    return Move.Rock;
                case 1:
                    return Move.Paper;
                default:
                    return Move.Scissor;
            }



        //return Move.Rock;
    }
}
