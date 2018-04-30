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
        buyHouse.addListener(new ChangeListener() {
          @Override
          public void changed(ChangeEvent event, Actor actor) {
            if (property.ownedBy.canPurchaseHouse((LotProperty)property)) {
              ((LotProperty) property).buyHouse();
              remove();
            }
          }
        });

        Button sellHouse = new TextButton("Sell House", getSkin());
        sellHouse.padRight(10).padLeft(10);
        sellHouse.setColor(Color.RED);
        sellHouse.addListener(new ChangeListener() {
          @Override
          public void changed(ChangeEvent event, Actor actor) {
            ClickListener action = new ClickListener(){
              @Override
              public void clicked(InputEvent event, float x, float y) {
                if (property.ownedBy.canSellHouse((LotProperty)property)) {
                  ((LotProperty) property).sellHouse();
                }
              }
            };
            if(property.ownedBy.canSellHouse((LotProperty)property)){
              new PopupDialog(action, "sell a house");
            }
          }
        });
        getContentTable().row(); // put text under image
        button(buyHouse);
        button(sellHouse);
      }
    }
    super.clickedDialogue();
  }
}
