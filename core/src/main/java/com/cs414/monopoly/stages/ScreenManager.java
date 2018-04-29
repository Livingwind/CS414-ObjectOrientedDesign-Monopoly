package com.cs414.monopoly.stages;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Batch;

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

  Screen getScreen() {
   return game.getScreen();
  }

  void showScreen(Screens screen, Batch batch, Object... params) {
    AbstractScreen newScreen = screen.getScreen(batch, params);
    changeScreen(newScreen, params);
  }

  public void showScreen(Screens screen, Object... params) {
    AbstractScreen newScreen = screen.getScreen(params);
    changeScreen(newScreen, params);
  }

  private void changeScreen(AbstractScreen screen, Object... params) {
    Screen current = game.getScreen();

    screen.build();
    game.setScreen(screen);

    if(current != null) {
      current.dispose();
    }

  }
}
