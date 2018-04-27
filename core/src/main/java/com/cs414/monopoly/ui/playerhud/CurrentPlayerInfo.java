package com.cs414.monopoly.ui.playerhud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.ui.Listeners;
import com.cs414.monopoly.ui.MonopolySkin;

public class CurrentPlayerInfo extends Window {
  private Listeners listeners = new Listeners();
  private Label text = new Label("", getSkin());
  private TextButton toggle = new TextButton("", getSkin());
  private ClickListener toggleListener = new ClickListener();
  private boolean showTable;
  public static float width = Gdx.graphics.getWidth()/4f; // PropertyTable uses this width

  public CurrentPlayerInfo() {
    super("Current Player", new MonopolySkin());
    resize();
    setMovable(false);
    initToggle();
    add(text).align(Align.left);
    row();
    add(toggle);
    row();
    add(GameState.getInstance().propertyTable).expand().width(200);
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

  private void resize() {
    if(!showTable) {
      setSize(width, Gdx.graphics.getHeight()/10f);
    } else {
      setSize(width, Gdx.graphics.getHeight()/10f + GameState.getInstance().propertyTable.getHeight());
    }
  }

  public void toggleProperties(boolean visibility){
    showTable = visibility;
    resize();
    GameState.getInstance().propertyTable.setVisible(showTable);
  }

  private void setToggleText() {
    String msg = ((showTable)? "Hide" : "Show") + " Properties";
    toggle.setText(msg);
  }

  private void initToggle() {
    toggle.setColor(Color.DARK_GRAY);
    toggle.addListener(new ChangeListener() {
      @Override
      public void changed(ChangeListener.ChangeEvent event, Actor actor) {
        toggleProperties(!showTable);
      }
    });
  }
}
