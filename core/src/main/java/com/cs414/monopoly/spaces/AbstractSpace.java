package com.cs414.monopoly.spaces;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;

import java.util.ArrayList;

public abstract class AbstractSpace extends WidgetGroup {

  public enum Size {
    STANDARD(83, 132), CORNER(133, 133);

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

  private final Sprite sprite;
  protected ArrayList<Player> players = new ArrayList<>();
  public final int location;



  public AbstractSpace(String formatPath, int location, JsonValue props, Size size) {
    setBounds(0, 0, size.getWidth(),size.getHeight());
    String path = String.format(formatPath, "spaces");
    sprite = new Sprite(new Texture(Gdx.files.internal(path)));
    sprite.setSize(getWidth(), getHeight());
    addActor(new Image(new SpriteDrawable(sprite)));

    this.location = location;
    setName(props.get("name").asString());

  }

  public void setSpriteColor(Color color){
    sprite.setColor(color);
  }

  protected void repositionPlayers() {
    for(int i = 0; i < players.size(); i++){
      Player player = players.get(i);
      player.setPosition((getWidth()-player.getWidth())-(player.getWidth()*(i%2)),
          getHeight() - player.getHeight()*((i/2)+1));
    }
  }

  public void placePlayer(Player player) {
    player.space.removePlayer(player);
    setPlayer(player);
    onLand(player);
  }

  public void setPlayer(Player player) {
    players.add(player);
    addActor(player);
    player.space = this;
    invalidate();
  }

  private void removePlayer(Player player) {
    players.remove(player);
    removeActor(player);
    invalidate();
  }

  @Override
  public void layout() {
    for(int i = 0; i < players.size(); i++) {
      repositionPlayers();
    }

    super.layout();
  }

  protected abstract void onLand(Player player);
}
