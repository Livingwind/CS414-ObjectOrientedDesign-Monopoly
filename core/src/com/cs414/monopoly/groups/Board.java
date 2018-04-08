package com.cs414.monopoly.groups;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.spaces.Lot;
import com.cs414.monopoly.spaces.Space;
import com.cs414.monopoly.spaces.SpaceFactory;

import java.util.ArrayList;

public class Board extends Group {
  private Sprite sprite = new Sprite(new Texture(Gdx.files.internal("assets/blank_board.png")));
  private float ratio = (float)Gdx.graphics.getHeight()/Gdx.graphics.getWidth();
  private float width = 1024*ratio;
  private float height = 1024*ratio;

  ArrayList<Space> spaces = new ArrayList<Space>(40);

  private void placeSpace(String path, JsonValue props, Vector2 pos, Space.Direction dir) {
    Space temp = SpaceFactory.createSpace(path, props);
    temp.alignToBoard(pos, dir);
    addActor(temp);
    spaces.add(temp);
  }

  private void initSpaces(String preset) {
    JsonValue root = new JsonReader().parse(Gdx.files.internal("assets/"+preset+"/config.json"));

    String path = "assets/"+preset+"/spaces/";
    Vector2 pos = new Vector2(getWidth()- Space.Size.CORNER.getWidth(), 0);

    // Add GO
    placeSpace(path, root.get(0), pos, Space.Direction.UP);

    // Add bottom row
    for(int i = 1; i < 10; i++) {
      pos.x -= Space.Size.STANDARD.getWidth();
      placeSpace(path, root.get(i), pos, Space.Direction.UP);
    }

    // Add Jail
    pos.x -= Space.Size.CORNER.getWidth();
    placeSpace(path, root.get(10), pos, Space.Direction.RIGHT);

    // Add left row
    pos.set(0, Space.Size.CORNER.getHeight());
    for(int i = 1; i < 10; i++) {
      placeSpace(path, root.get(i+10), pos, Space.Direction.RIGHT);
      pos.y += Space.Size.STANDARD.getWidth();
    }

    // Add free parking
    placeSpace(path, root.get(20), pos, Space.Direction.DOWN);
    pos.x += Space.Size.CORNER.getWidth();

    // Add top row
    for(int i = 1; i < 10; i++) {
      placeSpace(path, root.get(i+20), pos, Space.Direction.DOWN);
      pos.x += Space.Size.STANDARD.getWidth();
    }

    // Add go to jail
    placeSpace(path, root.get(30), pos, Space.Direction.LEFT);

    // Add right row
    for(int i = 1; i < 10; i++) {
      pos.y -= Space.Size.STANDARD.getWidth();
      placeSpace(path, root.get(i+30), pos, Space.Direction.LEFT);
    }
  }

  public Board() {
    setSize(width, height);
    setPosition(Gdx.graphics.getWidth()/2-getWidth()/2,Gdx.graphics.getHeight()/2-getHeight()/2);
    sprite.setSize(getWidth(), getHeight());

    initSpaces("board_original");
    for(Space x: spaces) {
      System.out.println(x.getName());
    }
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
