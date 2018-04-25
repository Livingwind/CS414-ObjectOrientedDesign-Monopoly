package com.cs414.monopoly.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.cs414.monopoly.entities.LotProperty;
import com.cs414.monopoly.entities.Property;

public class LotDialog extends PropertyDialog {
  public LotDialog(Property property, DialogueContext context) {
    super(property, context);
    show(state.getStage());
  }

  @Override
  protected void clickedDialogue() {
    // buttons
    if(!property.mortgaged){

      if (property.ownedBy == state.getCurrentPlayer()) {
        Button buyHouse = new TextButton("Buy House", getSkin());
        buyHouse.padRight(10).padLeft(10);
        buyHouse.setColor(Color.GREEN);
        buyHouse.addListener(new ChangeListener() {
          @Override
          public void changed(ChangeEvent event, Actor actor) {
            if (((LotProperty) property).numHouses < 5) {
              ((LotProperty) property).buyHouse();
            }
            event.cancel();
          }
        });
        Button sellHouse = new TextButton("Sell House", getSkin());
        sellHouse.padRight(10).padLeft(10);
        sellHouse.setColor(Color.RED);
        sellHouse.addListener(new ChangeListener() {
          @Override
          public void changed(ChangeEvent event, Actor actor) {
            if (((LotProperty) property).numHouses > 0) {
              ((LotProperty) property).sellHouse();
            }
            event.cancel();
          }
        });
        button(buyHouse);
        button(sellHouse);
      }
    }
    super.clickedDialogue();
  }
}

