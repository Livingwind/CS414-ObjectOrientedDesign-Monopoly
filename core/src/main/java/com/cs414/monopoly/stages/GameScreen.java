package com.cs414.monopoly.stages;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.groups.Board;

public class GameScreen extends AbstractScreen {
  GameScreen() {
    super();
  }

  GameScreen(Batch batch) {
    super(batch);
  }
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
