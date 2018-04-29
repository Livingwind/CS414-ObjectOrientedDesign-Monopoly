package com.cs414.monopoly.ui.trade;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Align;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.ui.MonopolySkin;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class TradeTable extends Table {
  private TradeContentManager propertyContent;
  private Label offerLabel = new Label("$", new MonopolySkin());
  private NetWorthLabel tradeNetWorth = new NetWorthLabel();
  private final TextField offerTextField = new TextField("", new MonopolySkin());

  public TradeTable(Player player, Boolean swap){
    Label invisRow = new Label("", new MonopolySkin());

    propertyContent = new TradeContentManager(player, swap, tradeNetWorth);
    add(propertyContent);
    row();
    Table offer = new Table();
    offerLabel.setColor(Color.GREEN);
    offer.add(offerLabel).align(Align.right);
    offer.add(offerTextField).align(Align.left);
    add(tradeNetWorth);
    row();
    add(invisRow);
    row();
    add(offer);
  }

  public ArrayList<Property> getTradedProperties(){
    return propertyContent.selectedProperties;
  }

  public int getOffer(){
    try {
      return abs(Integer.parseInt(offerTextField.getText()));
    } catch (NumberFormatException e){
      return 0;
    }
  }
}
