package com.cs414.monopoly.ui.trade;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.cs414.monopoly.entities.LotProperty;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.ui.MonopolySkin;

import java.util.ArrayList;

public class TradeContent extends Table {
  public Table buttonTable = new Table();
  public Table labelTable = new Table();
  public ArrayList<Property> selectedProperties = new ArrayList<>();

  public TradeContent(Player player, NetWorthLabel netWorth){
    fillTables(player, netWorth);
  }

  private void fillTables(Player player, NetWorthLabel netWorth){
    Label buttonTablePadding = new Label("________________________", new MonopolySkin());
      buttonTablePadding.setVisible(false);
    Label labelTablePadding = new Label("________________________", new MonopolySkin());
      labelTablePadding.setVisible(false);
    buttonTable.add(buttonTablePadding);
    buttonTable.row();
    labelTable.add(labelTablePadding);
    labelTable.row();

    for (Property property : player.properties){
      Label propertyLabel = new Label(property.name, new MonopolySkin());
      propertyLabel.setVisible(false);
      if (property.mortgaged){
        propertyLabel.setColor(Color.MAGENTA);
      }

      TradePropertyButton propertyButton;
      // It's a Lot
      if (LotProperty.class == property.getClass()){
        // Lot with houses: can't trade
        if (((LotProperty)property).numHouses > 0){
          propertyButton = new TradePropertyButton(propertyLabel);
        }
        // Lot without houses
        else {
          propertyButton = new TradePropertyButton(property, propertyLabel, selectedProperties, netWorth);
        }
      }
      // It's not a Lot
      else {
        propertyButton = new TradePropertyButton(property, propertyLabel, selectedProperties, netWorth);
      }
      buttonTable.add(propertyButton).expandX().fill();
      buttonTable.row();
      labelTable.add(propertyLabel).expandX().fill();
      labelTable.row();
    }
  }
}
