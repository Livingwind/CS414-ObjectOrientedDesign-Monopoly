package com.cs414.monopoly.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.cs414.monopoly.entities.LotProperty;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.entities.RailroadProperty;
import com.cs414.monopoly.entities.UtilityProperty;

import javax.rmi.CORBA.Util;

public abstract class PropertyDialog extends BlankDialog {
  protected final Property property;

  protected PropertyDialog(Property property, DialogueContext context){
    super(property.name + " - $" + property.value);
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

  private void mortgageButton() {
    if(property.ownedBy == state.getCurrentPlayer()) {
      Button mortgageProperty = (property.mortgaged) ? new TextButton("Un-Mortgage", getSkin()) : new TextButton("Mortgage", getSkin());

      mortgageProperty.padRight(10).padLeft(10);
      mortgageProperty.setColor(Color.MAGENTA);
      mortgageProperty.addListener(new ChangeListener(){
        @Override
        public void changed(ChangeEvent event, Actor actor){
          property.toggleMortgage();
          event.cancel();
          remove();
        }
      });
      button(mortgageProperty);
    }
  }
  void clickedDialogue() {
    addCloseButton();
    String owner = "Property " + ((property.ownedBy == null) ? "not owned" :
        "owned by: " + property.ownedBy.name + "\n");
    String mortgaged = "Property is mortgaged";

    Label message;
    if((property.ownedBy == null || !property.mortgaged))
      message = new Label(owner, getSkin());
    else{
      message = new Label(owner + mortgaged, getSkin());
      message.setColor(Color.RED);
    }
    text(message);
    message.setAlignment(Align.center);

    getContentTable().row();

    int buyBack = (int) ((property.value/2) *1.10);
    if(property.ownedBy != null && (property.ownedBy.getMoney() >= buyBack && property.mortgaged) || !property.mortgaged)
      mortgageButton();

  }

  private void landedDialogue() {
    getTitleLabel().setText("You landed on " + titleFormat(property.name));
    if(property.ownedBy == null) {
      unownedOptions();
    } else {
      ownedOptions();
    }
  }

  private String handlePayment() {
    if(property.mortgaged){
      return "This property is mortgaged";
    }else {
      state.getCurrentPlayer().modifyMoney(-property.getRent());
      property.ownedBy.modifyMoney(+property.getRent());
      return String.format("You paid %s $%d.", property.ownedBy.name, property.getRent());
    }
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
    Label message = new Label(String.format("%s costs $%d.\n\nYou don't have enough\nmoney to purchase this property.",
        titleFormat(property.name), property.value), getSkin());
    message.setAlignment(Align.center);
    text(message);
  }
}
