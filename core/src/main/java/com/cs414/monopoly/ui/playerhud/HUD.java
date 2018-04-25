package com.cs414.monopoly.ui.playerhud;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.ui.Buttons;
import com.cs414.monopoly.ui.Listeners;

public class HUD extends Group {
  private Buttons buttons = new Buttons();
  private Listeners listeners = new Listeners();
  private Stage stage = GameState.getInstance().getStage();

  // HUD objects
  private CurrentPlayerInfo playerInfo;

  public HUD(){
    playerInfo = new CurrentPlayerInfo();
    stage.addActor(playerInfo);
    buttons.addSettingsButton(listeners.getTextListener("Settings not implemented yet!"));
  }

  public void update(){
    playerInfo.invalidate();
  }

  public void nextTurn(){
    playerInfo.invalidate();
    playerInfo.toggleProperties(false);
  }

}
