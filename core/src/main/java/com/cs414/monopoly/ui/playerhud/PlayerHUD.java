package com.cs414.monopoly.ui.playerhud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.ui.Buttons;
import com.cs414.monopoly.ui.Listeners;

public class PlayerHUD extends Group {
  private Buttons buttons = new Buttons();
  private Listeners listeners = new Listeners();

  // PlayerHUD objects
  private CurrentPlayerInfo playerInfo;
  public Player player;

  public PlayerHUD(Player player) {
    this.player = player;
    playerInfo = new CurrentPlayerInfo(player);
    addActor(playerInfo);
    placeSettingsButton();
    setVisible(false);
  }

  private void placeSettingsButton() {
    Button settingsButton = buttons.getSettingsButton();
    settingsButton.addListener(listeners.getTextListener("Settings button not implemented yet!"));
    settingsButton.setPosition(0, Gdx.graphics.getHeight()-settingsButton.getHeight());
    addActor(settingsButton);
  }

  public void update() {
    playerInfo.update();
  }
}
