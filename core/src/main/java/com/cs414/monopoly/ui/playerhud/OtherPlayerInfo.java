package com.cs414.monopoly.ui.playerhud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;

public class OtherPlayerInfo extends PlayerInfo{

  public OtherPlayerInfo() {
    super("Other Players");
    resize();
    setMovable(false);
    initToggle();
    row();
    add(toggle);
    row();
    add(GameState.getInstance().propertyTable).expand().width(200);
  }

  protected void setToggleText() {
    String msg = ((showTable)? "Hide" : "Show") + " Players";
    toggle.setText(msg);
  }

  @Override
  public void layout() {
    super.layout();
    setPosition(0, Gdx.graphics.getHeight()-getHeight());
    Player player = GameState.getInstance().getCurrentPlayer();
    String name = String.format("Current Player: %s", player.name);
    String money = String.format("Money: $%d", player.getMoney());
    getTitleLabel().setText(name);
    setColor(player.color);
    setToggleText();
    resize();
  }
}
