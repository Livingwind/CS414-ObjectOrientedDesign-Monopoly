package com.cs414.monopoly.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class Man extends Image {
  private float width = Gdx.graphics.getWidth()*.1f;
  private float height = Gdx.graphics.getHeight()*.18f;
  Sprite sprite = new Sprite(new Texture(Gdx.files.internal("assets/monopoly_man.png")));

  public Color tint = Color.WHITE;

  public Man(float x, float y) {
    setDrawable(new SpriteDrawable(sprite));
    setBounds(x, y, width, height);
    setName("Man");

    setTouchable(Touchable.enabled);
    addListener(new ClickListener() {
      @Override
      public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        setColor(tint);
      }

      @Override
      public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        setColor(Color.WHITE);
      }
    });
  }
}
