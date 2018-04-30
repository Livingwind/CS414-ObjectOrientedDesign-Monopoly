package com.cs414.monopoly.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.cs414.monopoly.entities.*;
import com.cs414.monopoly.game.GameState;
import com.cs414.monopoly.groups.Board;
import com.cs414.monopoly.ui.dialog.LotDialog;
import com.cs414.monopoly.ui.dialog.RailroadDialog;
import com.cs414.monopoly.ui.dialog.TradeDialog;
import com.cs414.monopoly.ui.dialog.UtilityDialog;

public class Listeners {

  // a temporary listener used for buttons that aren't implemented yet
  public ClickListener textListener(String text){
    return new ClickListener(){
      @Override
      public void clicked(InputEvent event, float x, float y) {
        System.out.println(text);
      }
    };
  }

  public ClickListener closeListener(Actor removeActor) {
    return new ClickListener() {
      @Override
      public void  clicked(InputEvent event, float x, float y) {
        removeActor.remove();
      }
    };
  }

  public ClickListener toggleListener(Player player){
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

  public ClickListener tradeListener(Player current, Player other){
    return new ClickListener(){
      @Override
      public void clicked(InputEvent event, float x, float y) {
        new TradeDialog(current, other);
      }
    };
  }

  // Property Listeners___________________________________________________________________________

  public ClickListener hoverListener(Player player, Property property) {
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

  public ClickListener propertyDialogListener(Property property){
    return new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        if (property.getClass() == LotProperty.class){
          new LotDialog(property, DialogContext.CLICK);
        } else if(property.getClass() == RailroadProperty.class){
          new RailroadDialog(property, DialogContext.CLICK);
        } else if(property.getClass() == UtilityProperty.class){
          new UtilityDialog(property, DialogContext.CLICK);
        }
      }
    };
  }

  public ClickListener sellHouseListener(Property property) {
    return new ClickListener() {
      @Override
      public void  clicked(InputEvent event, float x, float y) {
        ((LotProperty)property).sellHouse();
      }
    };
  }

  public ClickListener buyHouseListener(Property property) {
    return new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        ((LotProperty)property).buyHouse();
      }
    };
  }
}
