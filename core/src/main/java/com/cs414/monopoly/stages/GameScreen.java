package com.cs414.monopoly.stages;

import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.groups.Board;

public class GameScreen extends AbstractScreen {
  /**
   * Builds the stage according to the instructions delegated
   * by the subclass.
   */
  @Override
  public void build() {
    Board board = new Board();
    addActor(board);

    GameState state = GameState.getInstance();
    state.setStage(this);
    state.setBoard(board);

    state.startGame(100000);
  }
}
