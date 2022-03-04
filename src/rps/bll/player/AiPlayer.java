package rps.bll.player;

import rps.bll.game.IGameState;
import rps.bll.game.Move;

import java.util.ArrayList;
import java.util.List;

public class AiPlayer implements IPlayer{


    @Override
    public String getPlayerName() {
        return null;
    }

    @Override
    public PlayerType getPlayerType() {
        return null;
    }

    ArrayList<Move> playerMoves = new ArrayList<>();
    @Override
    public Move doMove(IGameState state) {
      double random = Math.random() * 3;
      int randomNumber = (int) random;


        state.getHistoricResults().forEach((result) -> {
            if( result.getWinnerPlayer().equals("Hans")){
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

        for (Move move: possibleMoves) {
            if (playerMoves.get(playerMoves.size() - 1).equals(move)){
                for (Move testMove: playerMoves) {
                    if (testMove.equals(move))
                    rightMoves.add(playerMoves.get(count));
                    count++;
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


      switch (randomNumber) {
          case 0:
              return Move.Rock;
          case 1:
              return Move.Paper;
          default:
              return Move.Scissor;
      }


    }
}
