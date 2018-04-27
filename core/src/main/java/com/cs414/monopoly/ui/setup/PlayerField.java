package com.cs414.monopoly.ui.setup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.ui.MonopolySkin;

public class PlayerField extends Group {
  private final String path;
  private final Color color;
  private final Image icon;
  private final TextField text = new TextField("", new MonopolySkin());

  private boolean active = true;

  PlayerField(String image, Color color) {
    this.color = color;
    path = "assets/board_original/players/" + image;
    icon = new Image(new SpriteDrawable(new Sprite(new Texture(Gdx.files.internal(path)))));
    icon.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        active = !active;
        if(active) {
          icon.setColor(Color.WHITE);
          text.setColor(Color.WHITE);
          text.setDisabled(false);
        } else {
          icon.setColor(Color.RED);
          text.setColor(Color.GRAY);
          text.setDisabled(true);
        }
        ((SetupDialog)getParent()).updateNumPlayers();
      }
    });

    text.setTextFieldListener((TextField textField, char c) -> ((SetupDialog) getParent()).updateNumPlayers());

    setOrigin(getWidth()/2, getHeight()/2);
    setSize(200, 50);

    addActor(text);
    addActor(icon);
  }

  @Override
  protected void setParent(Group parent) {
    super.setParent(parent);
    setSize(parent.getWidth()/2, parent.getHeight()/8);
    setPosition(parent.getWidth()/2, parent.getHeight()/2, Align.center);
  }

  @Override
  protected void sizeChanged() {
    icon.setSize(getWidth()/8, getHeight()-getHeight()/5);
    icon.setOrigin(icon.getWidth()/2, icon.getHeight()/2);
    icon.setRotation(180);

    text.setX(icon.getWidth() + getWidth()/16);
    text.setWidth(getWidth()-icon.getWidth());

    super.sizeChanged();
  }

  Player constructPlayer() {
    return new Player(path, text.getText(), color, 1500);
  }

  boolean isValid() {
    if(text.getText().equals("")) {
      return false;
    }

    return active;
  }
}
