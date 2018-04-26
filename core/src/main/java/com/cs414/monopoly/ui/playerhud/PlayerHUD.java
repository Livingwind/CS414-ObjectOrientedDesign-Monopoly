package com.cs414.monopoly.ui.playerhud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.ui.Buttons;
import com.cs414.monopoly.ui.Listeners;

public class PlayerHUD extends Group {
  private Buttons buttons = new Buttons();
  private Listeners listeners = new Listeners();

  // PlayerHUD objects
  private CurrentPlayerInfo playerInfo;
  public Player player;
  private Button settingsButton = buttons.getSettingsButton();
  private Scoreboard scoreboard = new Scoreboard();
  private Button scoreboardButton = new ScoreboardButton(scoreboard);


  public PlayerHUD(Player player) {
    this.player = player;
    playerInfo = new CurrentPlayerInfo(player);
    addActor(playerInfo);
    placeSettingsButton();
    placeScoreboardButton();
    placeScoreboard();
    setVisible(false);
  }

  private void placeScoreboard(){
    scoreboard.setPosition(0, Gdx.graphics.getHeight()-scoreboardButton.getHeight()-scoreboard.getHeight());
    addActor(scoreboard);
  }

  private void placeScoreboardButton(){
    scoreboardButton.setPosition(settingsButton.getWidth(), Gdx.graphics.getHeight()-scoreboardButton.getHeight());
    addActor(scoreboardButton);
  }

  private void placeSettingsButton() {
    settingsButton.addListener(listeners.getTextListener("Settings button not implemented yet!"));
    settingsButton.setPosition(0, Gdx.graphics.getHeight()-settingsButton.getHeight());
    addActor(settingsButton);
  }

  public void update() {
    playerInfo.update();
  }
}
