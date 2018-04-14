package com.cs414.monopoly.spaces;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;

import java.util.ArrayList;

public abstract class AbstractSpace extends Group {

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

  private final Sprite sprite;
  private ArrayList<Player> players = new ArrayList<Player>();
  public final int location;


  public AbstractSpace(String formatPath, int location, JsonValue props, Size size) {
    setBounds(0, 0, size.getWidth(),size.getHeight());
    String path = String.format(formatPath, "spaces");
    sprite = new Sprite(new Texture(Gdx.files.internal(path)));
    sprite.setSize(getWidth(), getHeight());
    addActor(new Image(new SpriteDrawable(sprite)));

    this.location = location;
    setName(props.get("name").asString());

    final GameState state = GameState.getInstance();
    addListener(new ClickListener() {
      @Override
      public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        sprite.setColor(state.getCurrentPlayer().color);
      }

      @Override
      public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        sprite.setColor(Color.WHITE);
      }
    });
  }

  public void repositionPlayer(Player player, int index) {
    player.setPosition((getWidth()-player.getWidth())/2,
    (getHeight()-player.getHeight())-(player.getHeight()*index));
  }

  public void placePlayer(Player player) {
    player.space.removePlayer(player);
    setPlayer(player);
    onLand(player);
  }

  public void setPlayer(Player player) {
    players.add(player);
    addActor(player);
    repositionPlayer(player, players.size()-1);
    player.space = this;
  }

  public void removePlayer(Player player) {
    players.remove(player);
    for(int i = 0; i < players.size(); i++) {
      repositionPlayer(players.get(i), i);
    }
    removeActor(player);
  }

  protected abstract void onLand(Player player);
}
