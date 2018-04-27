package com.cs414.monopoly.stages;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class ScreenManager {
  private static ScreenManager instance;

  private Game game;

  private ScreenManager() {}

  public static ScreenManager getInstance() {
    if (instance == null) {
      instance = new ScreenManager();
    }
    return instance;
  }

  public void init(Game game) {
    this.game = game;
  }

  public void showScreen(Screens screen, Object... params) {
    Screen current = game.getScreen();

    AbstractScreen newScreen = screen.getScreen(params);
    newScreen.build();
    game.setScreen(newScreen);

    if(current != null) {
      current.dispose();
    }
  }
}
