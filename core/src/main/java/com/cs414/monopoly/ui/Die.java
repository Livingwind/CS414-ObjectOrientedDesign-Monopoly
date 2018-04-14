package com.cs414.monopoly.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

import java.util.ArrayList;

public class Die extends Image {
  private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
  private int currentface;

  public Die() {
    for(int i = 1; i <= 6; ++i) {
      sprites.add(new Sprite(new Texture(Gdx.files.internal("assets/dice/Dice_" + i + ".png"))));
    }
    setDrawable(new SpriteDrawable(sprites.get(0)));
  }

  public void changeFace(int num) {
    if(num == 0) {
      setDrawable(null);
    }
    setDrawable(new SpriteDrawable(sprites.get(num)));
  }
}
