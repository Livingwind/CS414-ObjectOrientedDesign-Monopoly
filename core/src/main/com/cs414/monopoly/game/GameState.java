package main.com.cs414.monopoly.game;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameState {
  private static GameState instance;
  public static GameState getInstance() {
    if(instance == null) {
      instance = new GameState();
    }
    return instance;
  }

  private Stage stage;

  private GameState() {
  }

  public void setStage(Stage stage) {
    if(this.stage == null) {
      this.stage = stage;
    } else {
      System.err.println("Stage already assigned.");
    }
  }

  public Stage getStage() {
    return stage;
  }
}
