package com.cs414.monopoly.groups;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Man;
import com.cs414.monopoly.spaces.Space;

import java.util.ArrayList;

public class Board extends Group {
  private Sprite sprite = new Sprite(new Texture(Gdx.files.internal("assets/blank_board.png")));
  private float ratio = (float)Gdx.graphics.getHeight()/Gdx.graphics.getWidth();
  private float width = 1024*ratio;
  private float height = 1024*ratio;

  ArrayList<Space> spaces = new ArrayList<Space>(40);

  public Board() {
    setSize(width, height);
    setPosition(Gdx.graphics.getWidth()/2-getWidth()/2,Gdx.graphics.getHeight()/2-getHeight()/2);
    sprite.setSize(getWidth(), getHeight());
  }

  @Override
  public void draw(Batch batch, float parentAlpha) {
    sprite.draw(batch);
    super.draw(batch, parentAlpha);
  }


  /**
   * Called when the actor's position has been changed.
   */
  @Override
  protected void positionChanged() {
    sprite.setPosition(getX(), getY());
  }
}
