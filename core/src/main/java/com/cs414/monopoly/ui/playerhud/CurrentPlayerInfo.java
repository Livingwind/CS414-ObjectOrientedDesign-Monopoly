package com.cs414.monopoly.ui.playerhud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.ui.MonopolySkin;

public class CurrentPlayerInfo extends Window {
  private Label text = new Label("", getSkin());
  private TextButton toggle = new TextButton("", getSkin());
  private Table test = new PropertyTable();
  private boolean showTable;

  public CurrentPlayerInfo() {
    super("Current Player", new MonopolySkin());
    resize();
    setMovable(false);
    initToggle();

    add(text).align(Align.left);
    row();
    add(toggle);
    row();
    add(test).expand().width(200);
  }

  @Override
  public void layout() {
    super.layout();
    setPosition(Gdx.graphics.getWidth()-getWidth(), Gdx.graphics.getHeight()-getHeight());

    Player player = GameState.getInstance().getCurrentPlayer();
    String name = String.format("Current Player: %s", player.name);
    String money = String.format("Money: $%d", player.getMoney());
    getTitleLabel().setText(name);
    text.setText(money);

    setToggleText();
    resize();
  }

  private void resize() {
    if(!showTable) {
      setSize(Gdx.graphics.getWidth()/4f, Gdx.graphics.getHeight()/10f);
    } else {
      setSize(Gdx.graphics.getWidth()/4f, Gdx.graphics.getHeight()/10f + test.getHeight());
    }
  }

  public void toggleProperties(boolean visibility){
    showTable = visibility;
    resize();
    test.setVisible(showTable);
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
  };
}
