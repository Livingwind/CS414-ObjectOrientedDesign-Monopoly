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
  private Button settingsButton = buttons.settingsButton();
  private float scoreboardButtonWidth = Gdx.graphics.getWidth()/8f;
  private Scoreboard scoreboard;
  private Button scoreboardButton;


  public PlayerHUD(Player player) {
    this.player = player;
    playerInfo = new CurrentPlayerInfo(player);
    addActor(playerInfo);
    placeSettingsButton();
    scoreboard = new Scoreboard(settingsButton.getWidth()+scoreboardButtonWidth, player);
    scoreboard.setPosition(scoreboard.getWidth(), Gdx.graphics.getHeight()-settingsButton.getHeight()-scoreboard.getHeight());
    placeScoreboard();
    scoreboardButton = new ScoreboardButton(scoreboard, scoreboardButtonWidth);
    placeScoreboardButton();
    setVisible(false);
  }

  private void placeScoreboard() {
    scoreboard.setPosition(0, Gdx.graphics.getHeight()-settingsButton.getHeight()-scoreboard.getHeight());
    addActor(scoreboard);
  }

  private void placeScoreboardButton() {
    scoreboardButton.setPosition(settingsButton.getWidth(), Gdx.graphics.getHeight()-scoreboardButton.getHeight());
    addActor(scoreboardButton);
  }

  private void placeSettingsButton() {
    settingsButton.addListener(listeners.textListener("Settings button not implemented yet!"));
    settingsButton.setPosition(0, Gdx.graphics.getHeight()-settingsButton.getHeight());
    addActor(settingsButton);
  }

  public void updatePlayerInfo(){
    playerInfo.update();
  }

  public void updateScoreboard() {
    scoreboard.update();
  }

  public void update() {
    playerInfo.update();
    scoreboard.update();
  }
}
