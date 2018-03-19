package com.cs414.monopoly.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class Entity extends Image {
  private Sprite sprite;

  public Entity(Vector2 location, String filename) {
    setBounds(location.x, location.y, 200, 320);
    sprite = new Sprite(new Texture(filename));
    sprite.setSize(getWidth(), getHeight());

    setDrawable(new SpriteDrawable(sprite));

    this.setTouchable(Touchable.enabled);
    this.addListener(new InputListener(){
        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
          ((Entity)event.getTarget()).touchDown();
          return true;
        }
      });
  }

  int maxWidth = Gdx.graphics.getWidth();
  int maxHeight = Gdx.graphics.getHeight();

  protected boolean touchDown () {
    System.out.println("CLICKED");
    setPosition((getX()+100)%maxWidth, (getY()+100)%maxHeight);
    return true;
  }

  @Override
  public void act(float delta) {
    setPosition((getX()+5)%maxWidth, (getY()+5)%maxHeight);
  }
}
