package com.cs414.monopoly.ui.playerhud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.ui.Listeners;

public class CurrentPlayerInfo extends PlayerInfo {
  private Listeners listeners = new Listeners();
  private Label text = new Label("", getSkin());
  private ClickListener toggleListener = new ClickListener();

  public CurrentPlayerInfo() {
    super("Current Player");
    resize();
    setMovable(false);
    initToggle();
    add(text).align(Align.left);
    row();
    add(toggle);
    row();
    add(GameState.getInstance().propertyTable).expand().width(width);
  }

  private void addToggleMouseOver() {
    toggle.removeListener(toggleListener);
    toggleListener = listeners.getToggleListener(GameState.getInstance().getCurrentPlayer());
    toggle.addListener(toggleListener);
  }

  @Override
  public void layout() {
    super.layout();
    setPosition(Gdx.graphics.getWidth()-getWidth(), Gdx.graphics.getHeight()-getHeight());
    Player player = GameState.getInstance().getCurrentPlayer();
    String name = String.format("Current Player: %s", player.name);
    String money = String.format("Money: $%d", player.getMoney());
    getTitleLabel().setText(name);
    setColor(player.color);
    text.setText(money);
    setToggleText();
    addToggleMouseOver();
    resize();
  }
}
