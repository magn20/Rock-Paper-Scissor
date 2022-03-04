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
    
    @Override
    public Move doMove(IGameState state) {
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


    }
}
