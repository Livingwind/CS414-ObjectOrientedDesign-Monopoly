package com.cs414.monopoly.ui.playerhud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.ui.MonopolySkin;

public abstract class PlayerInfo extends Window {
  protected TextButton toggle = new TextButton("", getSkin());
  protected boolean showTable = false;
  public static float width = Gdx.graphics.getWidth()/4f; // PropertyTable uses this width

  protected void setToggleText() {
    String msg = ((showTable)? "Hide" : "Show") + " Properties";
    toggle.setText(msg);
  }

  public PlayerInfo(String title) {
    super(title, new MonopolySkin());
  }

  protected void resize() {
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

  protected void initToggle() {
    toggle.setColor(Color.DARK_GRAY);
    toggle.addListener(new ChangeListener() {
      @Override
      public void changed(ChangeListener.ChangeEvent event, Actor actor) {
        toggleProperties(!showTable);
      }
    });
  }
}
