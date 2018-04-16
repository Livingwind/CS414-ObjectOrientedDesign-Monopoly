package com.cs414.monopoly.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;

public class CurrentPlayerInfo extends Window {
  Label text = new Label("", getSkin());

  public CurrentPlayerInfo() {
    super("Current Player", new MonopolySkin());
    setSize(Gdx.graphics.getWidth()/4f, Gdx.graphics.getHeight()/16f);
    setPosition(Gdx.graphics.getWidth()-getWidth(), Gdx.graphics.getHeight()-getHeight());
    setMovable(false);
    align(Align.left);
    add(text);
    changePlayer(GameState.getInstance().getCurrentPlayer());
  }

  public void changePlayer(Player player) {
    String name = String.format("Current Player: %s", player.name);
    String money = String.format("Money: $%d", player.getMoney());
    getTitleLabel().setText(name);
    text.setText(money);
  }
}
