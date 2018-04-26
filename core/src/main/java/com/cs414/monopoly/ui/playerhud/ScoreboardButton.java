package com.cs414.monopoly.ui.playerhud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.cs414.monopoly.ui.MonopolySkin;

public class ScoreboardButton extends TextButton{
  private boolean showScoreboard = false;
  private Scoreboard scoreboard;

  public ScoreboardButton(Scoreboard scoreboard, float width) {
    super("Show Scoreboard", new MonopolySkin());
    this.scoreboard = scoreboard;
    setSize(width, Gdx.graphics.getWidth()/48f);
    initToggle();
  }

  private void toggleText() {
    String msg = ((showScoreboard)? "Hide" : "Show") + " Scoreboard";
    setText(msg);
  }

  private void toggleProperties(){
    showScoreboard = !showScoreboard;
    scoreboard.setVisible(showScoreboard);
  }

  private ChangeListener toggleListener = new ChangeListener() {
    @Override
    public void changed(ChangeListener.ChangeEvent event, Actor actor) {
      toggleProperties();
      toggleText();
    }
  };
  private void initToggle() {
    setColor(Color.LIGHT_GRAY);
    addListener(toggleListener);
  }

}
