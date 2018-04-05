package com.cs414.monopoly.groups;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Man;

public class Board extends Group {
  Sprite sprite = new Sprite(new Texture(Gdx.files.internal("assets/temp.png")));
  private float ratio = (float)Gdx.graphics.getHeight()/Gdx.graphics.getWidth();
  private float width = 1024*ratio;
  private float height = 1024*ratio;

  public Board() {
    setSize(width, height);
    setPosition(Gdx.graphics.getWidth()/2-getWidth()/2,Gdx.graphics.getHeight()/2-getHeight()/2);
    sprite.setSize(getWidth(), getHeight());
    Man m1 = new Man(0, 0);
    Man m2 = new Man( (getWidth()*1)/3, 0);
    Man m3 = new Man( (getWidth()*2)/3, 0);

    m1.tint = Color.FIREBRICK;
    m2.tint = Color.CYAN;
    m3.tint = Color.FOREST;

    addActor(m1);
    addActor(m2);
    addActor(m3);
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
