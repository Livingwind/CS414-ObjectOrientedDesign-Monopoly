package com.cs414.monopoly.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
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
            System.out.println("Bought a house!");
            event.cancel();
          }
        });
        Button sellHouse = new TextButton("Sell House", getSkin());
        sellHouse.padRight(10).padLeft(10);
        sellHouse.setColor(Color.RED);
        sellHouse.addListener(new ChangeListener() {
          @Override
          public void changed(ChangeEvent event, Actor actor) {
            System.out.println("Sold a house!");
            event.cancel();
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

