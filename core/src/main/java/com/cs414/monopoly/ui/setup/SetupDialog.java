package com.cs414.monopoly.ui.setup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.stages.ScreenManager;
import com.cs414.monopoly.stages.Screens;
import com.cs414.monopoly.ui.MonopolySkin;

import java.util.ArrayList;

public class SetupDialog extends Dialog {
  private ArrayList<PlayerField> fields = new ArrayList<>();
  private Button start;

  public SetupDialog() {
    super("Player Setup", new MonopolySkin());
    setMovable(false);
    setOrigin(getWidth()/2, getHeight()/2);
    setSize(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
    setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, Align.center);

    start = getStartButton();
    addActor(start);

    fields.add(new PlayerField("boat.png", Color.CYAN));
    fields.add(new PlayerField("car.png", Color.GREEN));
    fields.add(new PlayerField("dog.png", Color.BLUE));
    fields.add(new PlayerField("hat.png", Color.RED));

    float y = getHeight() - getHeight()/4;
    for(PlayerField field: fields) {
      addActor(field);
      field.setY(y);
      y -= field.getHeight();
    }
    updateNumPlayers();
  }

  private TextButton getStartButton() {
    TextButton b = new TextButton("START", new MonopolySkin());
    b.setOrigin(getWidth()/2, getHeight()/2);
    b.setWidth(getWidth()/5);
    b.setColor(Color.GREEN);
    b.setPosition(getWidth()/2, getHeight()/10, Align.center);
    b.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        ArrayList<Player> players = new ArrayList<>();
        for(PlayerField field: fields) {
          if(field.isValid()) {
            players.add(field.constructPlayer());
          }
        }
        GameState.getInstance().addPlayers(players);
        ScreenManager.getInstance().showScreen(Screens.GAME);
      }
    });

    return b;
  }

  void updateNumPlayers() {
    int ready = 0;
    for(PlayerField field: fields) {
      if(field.isValid()) {
        ready++;
      }
    }

    if(ready < 2) {
      start.setTouchable(Touchable.disabled);
      start.setColor(Color.GRAY);
    } else {
      start.setTouchable(Touchable.enabled);
      start.setColor(Color.GREEN);
    }
  }
}
