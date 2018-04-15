package com.cs414.monopoly.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.cs414.monopoly.entities.Property;

public abstract class PropertyDialog extends BlankDialog {
  protected final Property property;

  protected PropertyDialog(Property property, DialogueContext context){
    super(property.name);
    this.property = property;
    // image Table
    Table imageTable = new Table();
    Image image = new Image(property.texture);
    image.setScaling(Scaling.fit);
    imageTable.add(image).width(300).height(300);

    getContentTable().padTop(20);
    getContentTable().add(imageTable);
    getContentTable().row(); // put text under image

    switch (context) {
      case LAND:
        landedDialogue();
        break;
      case CLICK:
        clickedDialogue();
        break;
    }
  }

  void clickedDialogue() {
    addCloseButton();
    String owner = "Property " + ((property.ownedBy == null) ? "not owned" :
        "owned by: " + property.ownedBy.name);
    text(owner);
    getContentTable().row();
  }

  void landedDialogue() {
    getTitleLabel().setText("You landed on " + titleFormat(property.name));
    if(property.ownedBy == null) {
      unownedOptions();
    } else {
      ownedOptions();
    }
  }

  String handlePayment() {
    state.getCurrentPlayer().modifyMoney(-property.getRent());
    property.ownedBy.modifyMoney(+property.getRent());
    return String.format("You paid %s $%d.", property.ownedBy.name, property.getRent());
  }

  private void ownedOptions() {
    String message;
    if(property.ownedBy == state.getCurrentPlayer()) {
      message = "You already own this Property.";
    } else {
      message = handlePayment();
    }
    text(message);
    getContentTable().row();
    addOKButton();
  }

  void unownedOptions() {
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
    String price = String.format("Buy Property for $%d?", property.value);
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
    Label message = new Label(String.format("%s costs $%d.\n\nYou don't have enough\nmoney to purchase this Property.",
        titleFormat(property.name), property.value), getSkin());
    message.setAlignment(Align.center);
    text(message);
  }
}
