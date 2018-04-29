package com.cs414.monopoly.ui.auction;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.cs414.monopoly.entities.Property;

public class AuctionGroup extends Group {
  private AuctionDisplay display;

  public AuctionGroup(Property property){
    display = new AuctionDisplay(property);
    display.auctionWindow();
  }
}
