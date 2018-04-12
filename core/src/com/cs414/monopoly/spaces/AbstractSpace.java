package com.cs414.monopoly.spaces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.Player;

import java.util.ArrayList;
import java.util.Map;

public abstract class AbstractSpace extends Image{

  public enum Size {
    STANDARD(84, 133), CORNER(133, 133);

    private float ratio = (float)Gdx.graphics.getHeight()/Gdx.graphics.getWidth();
    private float width;
    private float height;

    Size(float width, float height) {
      this.width = width*ratio;
      this.height = height*ratio;
    }

    public float getWidth() {
      return width;
    }
    public float getHeight() {
      return height;
    }
  }

  public enum Direction {
    DOWN(0), LEFT(270), UP(180), RIGHT(90);

    private float degree;
    Direction(float degree) {
      this.degree = degree;
    }

    public float degree() {
      return degree;
    }
  }

  // CLASS --------------------------------------------------------------

  public AbstractSpace(String textureFilename, JsonValue props, Size size) {
    Sprite sprite = new Sprite(new Texture(Gdx.files.internal(textureFilename)));
    setDrawable(new SpriteDrawable(sprite));

    setBounds(0, 0, size.width, size.height);
    setName(props.get("name").asString());

    addListener(new ClickListener() {
      @Override
      public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        setColor(Color.CYAN);
      }

      @Override
      public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        setColor(Color.WHITE);
      }
    });
  }

  public void alignToBoard(Vector2 pos, Direction direction) {
    setPosition(pos.x, pos.y);
    switch(direction) {
      case DOWN:
        break;
      case LEFT:
        setY(getY()+getWidth());
        break;
      case RIGHT:
        setX(getX()+getHeight());
        break;
      case UP:
        setPosition(getX()+getWidth(), getY()+getHeight());
        break;
    }
    setRotation(direction.degree());
  }

  public abstract void onLand(Player player);
}
