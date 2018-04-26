package com.cs414.monopoly.ui.playerhud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.ui.MonopolySkin;

public class Scoreboard extends Window {
  private Label text = new Label("TEMPORARY", getSkin());

  public Scoreboard() {
    super("Scoreboard", new MonopolySkin());
    setVisible(false);
    setMovable(false);
    setSize(Gdx.graphics.getWidth()/4f, Gdx.graphics.getWidth()/16f);
    add(text).align(Align.left);
    row();
  }
}
