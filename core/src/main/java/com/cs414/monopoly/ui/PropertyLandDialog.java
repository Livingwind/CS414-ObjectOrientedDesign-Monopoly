package com.cs414.monopoly.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Property;

public class PropertyLandDialog extends PropertyDialog {

  public PropertyLandDialog(Property property) {
    super(property, false);
  }

  @Override
  public void fill() {
    getTitleLabel().setText("You landed on " + property.name);
    if(property.ownedBy == null) {
      unownedOptions();
    } else {
      ownedOptions();
    }
  }

  private void ownedOptions() {
    Label message;
    if(property.ownedBy == state.getCurrentPlayer()) {
      message = new Label("You already\nown this property.", getSkin());
    } else {
      message = new Label(String.format("You payed %s $%d for rent.",
          property.ownedBy.name, property.getRent()), getSkin());
      state.getCurrentPlayer().modifyMoney(-property.getRent());
      property.ownedBy.modifyMoney(+property.getRent());
    }

    message.setAlignment(Align.center);
    Button confirm = new TextButton("Ok", getSkin());
    confirm.padLeft(20).padRight(20);

    text(message);
    button(confirm);
  }

  private void unownedOptions() {
    if(property.value > state.getCurrentPlayer().getMoney()) {
      cantAffordOptions();
    } else {
      canAffordOptions();
    }

    Button auction = new TextButton("Auction", getSkin());
    auction.padRight(10).padLeft(10);
    auction.setColor(Color.RED);
    auction.addListener(new ChangeListener(){
      @Override
      public void changed(ChangeEvent event, Actor actor){
        System.out.println("AUCTION NOT IMPLEMENTED");
        remove();
      }
    });

    getContentTable().row(); // put text under image
    button(auction);
  }

  private void canAffordOptions() {
    String price = String.format("Buy property for $%d?", property.value);
    text(price);

    Button buyProperty = new TextButton("Buy Property", getSkin());
    buyProperty.padRight(10).padLeft(10);
    buyProperty.setColor(Color.GREEN);
    buyProperty.addListener(new ChangeListener(){
      @Override
      public void changed(ChangeEvent event, Actor actor){
        state.getCurrentPlayer().purchaseProperty(property);
        remove();
      }
    });

    button(buyProperty);
  }

  private void cantAffordOptions() {
    Label message = new Label(String.format("%s costs $%d.\nYou don't have enough\nmoney to purchase this property.",
        property.name, property.value), getSkin());
    message.setAlignment(Align.center);

    text(message);
  }
}
