package com.cs414.monopoly.ui.trade;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.ui.MonopolySkin;

import java.util.ArrayList;

public class TradeTable extends Table {
  private TradeContentManager propertyContent;

  private Label offer = new Label("Offer: ", new MonopolySkin());
  private final TextField moneyOffer = new TextField("", new MonopolySkin());

  public TradeTable(Player player, Boolean swap){
    propertyContent = new TradeContentManager(player, swap);
    add(propertyContent);
    row();
    add(offer);
  }

  public ArrayList<Property> getTradedProperties(){
    return propertyContent.selectedProperties;
  }
}
