package com.cs414.monopoly.stages;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.cs414.monopoly.ui.MonopolySkin;

public class SetupScreen extends AbstractScreen {
  /**
   * Builds the stage according to the instructions delegated
   * by the subclass.
   */
  @Override
  public void build() {
    Button b = new TextButton("PRESS", new MonopolySkin());
    b.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        ScreenManager.getInstance().showScreen(Screens.GAME);
      }
    });
    addActor(b);
  }
}
