package com.cs414.monopoly.groups;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.spaces.AbstractSpace;
import com.cs414.monopoly.spaces.SpaceFactory;

import java.util.ArrayList;

public class Board extends Group {
  private Sprite sprite = new Sprite(new Texture(Gdx.files.internal("assets/blank_board.png")));
  private float ratio = (float)Gdx.graphics.getHeight()/Gdx.graphics.getWidth();
  private float width = 1024*ratio;
  private float height = 1024*ratio;

  public ArrayList<AbstractSpace> spaces = new ArrayList<AbstractSpace>(40);
  public int jailIndex;

  private void placeSpace(String path, int location,
                          JsonValue props, Vector2 pos, AbstractSpace.Direction dir) {
    AbstractSpace temp = SpaceFactory.createSpace(path, location, props);
    temp.setPosition(pos.x, pos.y);
    temp.setRotation(dir.degree());
    addActor(temp);
    spaces.add(temp);

    if(props.getString("type").equals("jail")) {
      jailIndex = location;
    }
  }

  private void initSpaces(String preset) {
    JsonValue root = new JsonReader().parse(Gdx.files.internal("assets/"+preset+"/config.json"));

    String path = "assets/"+preset+"/%s/";
    Vector2 pos = new Vector2(getWidth(), AbstractSpace.Size.CORNER.getHeight());

    // Add GO
    placeSpace(path, 0, root.get(0), pos, AbstractSpace.Direction.UP);
    pos.x -= AbstractSpace.Size.CORNER.getWidth()+.5;

    // Add bottom row
    for(int i = 1; i < 10; i++) {
      placeSpace(path, i, root.get(i), pos, AbstractSpace.Direction.UP);
      pos.x -= AbstractSpace.Size.STANDARD.getWidth()+.5;
    }

    // Add Jail
    pos.y -= AbstractSpace.Size.CORNER.getHeight()+.5;
    placeSpace(path, 10, root.get(10), pos, AbstractSpace.Direction.RIGHT);
    pos.y += AbstractSpace.Size.CORNER.getHeight()+1;

    // Add left row
    for(int i = 1; i < 10; i++) {
      placeSpace(path, i+10, root.get(i+10), pos, AbstractSpace.Direction.RIGHT);
      pos.y += AbstractSpace.Size.STANDARD.getWidth()+.5;
    }

    // Add free parking
    pos.x -= AbstractSpace.Size.CORNER.getWidth()+.5;
    placeSpace(path, 20, root.get(20), pos, AbstractSpace.Direction.DOWN);
    pos.x += AbstractSpace.Size.CORNER.getWidth()+1;

    // Add top row
    for(int i = 1; i < 10; i++) {
      placeSpace(path, i+20, root.get(i+20), pos, AbstractSpace.Direction.DOWN);
      pos.x += AbstractSpace.Size.STANDARD.getWidth()+.5;
    }

    // Add go to jail
    pos.y += AbstractSpace.Size.CORNER.getHeight()+.5;
    placeSpace(path, 30, root.get(30), pos, AbstractSpace.Direction.LEFT);
    pos.y -= AbstractSpace.Size.CORNER.getHeight()+.5;

    // Add right row
    for(int i = 1; i < 10; i++) {
      placeSpace(path, 30+i, root.get(i+30), pos, AbstractSpace.Direction.LEFT);
      pos.y -= AbstractSpace.Size.STANDARD.getWidth()+.5;
    }
  }

  public Board() {
    setSize(width, height);
    setPosition(Gdx.graphics.getWidth()/2-getWidth()/2,Gdx.graphics.getHeight()/2-getHeight()/2);
    sprite.setSize(getWidth(), getHeight());

    initSpaces("board_original");
  }

  public void movePlayer(Player player, int num) {
    // Landed on/passed Go
    if(player.space.location + num >= spaces.size()) {
      player.modifyMoney(+200);
    }

    int landed = (player.space.location + num) % spaces.size();
    spaces.get(landed).placePlayer(player);
  }

  public void sendToJail(Player player) {
    System.out.println(player.name + " sent to jail.");
    player.inJail = true;
    spaces.get(jailIndex).placePlayer(player);
  }

  public void initPlayer(Player player) {
    spaces.get(0).setPlayer(player);
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
