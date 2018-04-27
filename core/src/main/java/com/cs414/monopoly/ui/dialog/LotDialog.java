package com.cs414.monopoly.ui.dialog;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.cs414.monopoly.entities.LotProperty;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.ui.DialogContext;

public class LotDialog extends PropertyDialog {
  public LotDialog(Property property, DialogContext context) {
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
        buyHouse.addListener(new ClickListener() {
          @Override
          public void clicked(InputEvent event, float x, float y) {
            if (((LotProperty) property).numHouses < 5) {
              ((LotProperty) property).buyHouse();
            }
            event.cancel();
          }
        });
        Button sellHouse = new TextButton("Sell House", getSkin());
        sellHouse.padRight(10).padLeft(10);
        sellHouse.setColor(Color.RED);
        sellHouse.addListener(new ClickListener() {
          @Override
          public void clicked(InputEvent event, float x, float y) {
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

