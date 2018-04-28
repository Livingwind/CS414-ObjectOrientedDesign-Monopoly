package com.cs414.monopoly.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.cs414.monopoly.entities.*;

public class Buttons {
  private Listeners listeners = new Listeners();

  public Button getCloseButton(Actor closeActor){
    Button exit = new TextButton("X", new MonopolySkin());
    exit.padRight(15).padLeft(15);
    exit.setColor(Color.RED);
    exit.addListener(listeners.getCloseListener(closeActor));
    return exit;
  }

  public Button getBuyButton(Property property){
    // todo: find a bitmap font that supports 🏠
    Button btn = new TextButton("Buy \uD83C\uDFE0", new MonopolySkin());
    btn.setColor(Color.GREEN);
    btn.addListener(new ChangeListener(){
      @Override
      public void changed(ChangeEvent event, Actor actor) {
        ((LotProperty)property).buyHouse();
      }
    });
    return btn;
  }

  public Button getGreyButton(String text){
    Button btn = new TextButton(text, new MonopolySkin());
    btn.setColor(Color.LIGHT_GRAY);
    return btn;
  }

  public Button getSellButton(Property property){
    // todo: find a bitmap font that supports 🏠
    Button btn = new TextButton("Sell \uD83C\uDFE0", new MonopolySkin());
    btn.setColor(Color.RED);
    btn.addListener(new ChangeListener(){
      @Override
      public void changed(ChangeEvent event, Actor actor) {
        ((LotProperty)property).sellHouse();
      }
    });
    return btn;
  }

  public Button getPropertyButton(Player player, Property property) {
    TextButton propertyButton = new TextButton(property.name, new MonopolySkin());

    // bring up property dialog when clicked
    propertyButton.addListener(new ChangeListener() {
      @Override
      public void changed(ChangeEvent event, Actor actor){
        if (property.getClass() == LotProperty.class){
          new LotDialog(property, DialogueContext.CLICK);
        } else if(property.getClass() == RailroadProperty.class){
          new RailroadDialog(property, DialogueContext.CLICK);
        } else if(property.getClass() == UtilityProperty.class){
          new UtilityDialog(property, DialogueContext.CLICK);
        }
      }
    });
    // highlight the property on the board when moused over
    propertyButton.addListener(listeners.getHoverListener(player, property));
    return propertyButton;
  }
}
