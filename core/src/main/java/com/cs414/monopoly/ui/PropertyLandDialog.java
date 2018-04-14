package com.cs414.monopoly.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.cs414.monopoly.entities.Property;

public class PropertyLandDialog extends PropertyDialog {

  public PropertyLandDialog(Property property) {
    super(property, false);
  }

  public void ownedOptions() {

  }

  public void unownedOptions() {
    String price = String.format("Buy property for $%d?", property.value);
    text(price);

    Button buyProperty = new TextButton("Buy Property", getSkin());
    buyProperty.padRight(10).padLeft(10);
    buyProperty.setColor(Color.GREEN);
    buyProperty.addListener(new ChangeListener(){
      @Override
      public void changed(ChangeEvent event, Actor actor){
        System.out.println("Bought");
        remove();
        event.cancel();
      }
    });
    Button auction = new TextButton("Auction", getSkin());
    auction.padRight(10).padLeft(10);
    auction.setColor(Color.RED);
    auction.addListener(new ChangeListener(){
      @Override
      public void changed(ChangeEvent event, Actor actor){
        System.out.println("Sent to auction");
        event.cancel();
      }
    });

    getContentTable().row(); // put text under image
    button(buyProperty);
    button(auction);
  }


  @Override
  public void fill() {
    getTitleLabel().setText("You landed on " + property.name);
    if(property.ownedBy != state.getCurrentPlayer()) {
      unownedOptions();
    } else {
      ownedOptions();
    }
  }
}
