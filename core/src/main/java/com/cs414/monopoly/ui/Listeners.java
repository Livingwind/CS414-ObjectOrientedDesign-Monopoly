package com.cs414.monopoly.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.groups.Board;

public class Listeners {
  public ChangeListener getCloseListener(Actor removeActor) {
    return new ChangeListener() {
      @Override
      public void changed(ChangeListener.ChangeEvent event, Actor actor) {
        removeActor.remove();
      }
    };
  }

  public ClickListener getHoverListener(Player player, Property property) {
    return new ClickListener() {
      Board board = GameState.getInstance().getBoard();
      @Override
      public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        board.spaces.get(property.location).setSpriteColor(player.color);
      }

      @Override
      public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        board.spaces.get(property.location).setSpriteColor(Color.WHITE);
      }
    };
  }

  public ClickListener getToggleListener(Player player){
    return new ClickListener() {
      Board board = GameState.getInstance().getBoard();
      @Override
      public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor) {
        for (int i = 0; i < player.properties.size(); ++i) {
          Property property = player.properties.get(i);
          board.spaces.get(property.location).setSpriteColor(player.color);
        }
      }
      @Override
      public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
        for (int i = 0; i < player.properties.size(); ++i) {
          Property property = player.properties.get(i);
          board.spaces.get(property.location).setSpriteColor(Color.WHITE);
        }
      }
    };
  }
}
