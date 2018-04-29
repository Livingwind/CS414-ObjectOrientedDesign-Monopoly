package com.cs414.monopoly.ui.auction;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Scaling;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.ui.BlankDialog;
import com.cs414.monopoly.ui.PopupDialog;

public class AuctionDisplay extends BlankDialog {

  private TextField bidInput = new TextField("1", getSkin());
  private Property property;
  private AuctionPlayerInfo playerInfo = new AuctionPlayerInfo();
  private Label highestBidder = new Label(highestBidderInfo(), getSkin());
  private Label bidders = new Label(playerInfo.playerInfo(), getSkin());


  public AuctionDisplay(Property property) {
    super("Auctioning " + property.name + " - $" + property.value);
    this.property = property;
    getContentTable().pad(20,30,10,10);
    highestBidder.setAlignment(Align.center);
    auctionButtons();
    auctionWindow();
    show(state.getStage());
  }

  private void auctionButtons() {
    Button bidButton = new TextButton("Bid", getSkin());
    bidButton.padRight(10).padLeft(10);
    bidButton.setColor(Color.GREEN);
    bidButton.addListener(new ChangeListener() {
      @Override
      public void changed(ChangeEvent event, Actor actor) {
        event.cancel();
        try {
          int newBid = Integer.parseInt(bidInput.getText());
          if(playerInfo.checkValidBid(newBid)){
            if(newBid > playerInfo.currentBidder().getMoney()) {
              ClickListener action = new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                  playerInfo.newHighestBidder(newBid);
                  takeTurn();
                  updateDisplay();
                  event.cancel();
                }
              };
              new PopupDialog(action, "spend more money than you have");
            }else{
              playerInfo.newHighestBidder(newBid);
              takeTurn();
              updateDisplay();
            }
          }else{
            new PopupDialog("Please enter a valid amount");
          }
        }catch(java.lang.NumberFormatException e){
          new PopupDialog("Please enter an integer");
        }
      }
    });
    Button passButton = new TextButton("Pass", getSkin());
    passButton.padRight(10).padLeft(10);
    passButton.setColor(Color.RED);
    passButton.addListener(new ChangeListener(){
      @Override
      public void changed(ChangeEvent event, Actor actor){
        event.cancel();
        takeTurn();
        if(!playerInfo.checkIfOver()) {
          updateDisplay();
        }
      }
    });
    button(bidButton);
    button(passButton);
  }

  private int incrementNextBid() {
    int newValue = playerInfo.highestBid() / (property.value/5);
    return (newValue + 1) * (property.value/5);
  }

  private void takeTurn() {
    playerInfo.nextPlayer();
    if(playerInfo.checkIfOver()){
      remove();
      sellProperty();
      new PopupDialog(playerInfo.highestBidder().name + " won " + property.name + " for $" + playerInfo.highestBid());
      //remove null values
      playerInfo.playerList.remove(0);
      playerInfo.bids.remove(0);
    }
  }

  private void sellProperty() {
    int currentValue = property.value;
    property.value = playerInfo.highestBid();
    playerInfo.highestBidder().purchaseProperty(property);
    property.value = currentValue;
  }

  private void updateDisplay() {
    highestBidder.setText(highestBidderInfo());
    bidders.setText(playerInfo.playerInfo());
    bidInput.setText(incrementNextBid() + "");
  }

  private String highestBidderInfo() {
    String highestBidder = "Highest Bidder: " + ((playerInfo.highestBidder() == null) ? "" : playerInfo.highestBidder().name);
    highestBidder += "\n$" + playerInfo.highestBid();
    return highestBidder;
  }

  public void auctionWindow() {
    Table imageTable = new Table();
    Image image = property.image;
    image.setScaling(Scaling.fit);
    imageTable.add(image).width(300).height(300);
    getContentTable().clear();
    getContentTable().add();
    text(highestBidder);
    getContentTable().row();
    getContentTable().add(bidders).width(200);
    getContentTable().add(imageTable);
    getContentTable().row();
    text("Enter a new bid: ");
    getContentTable().add(bidInput);

  }
}
