package com.cs414.monopoly.ui.trade;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.cs414.monopoly.entities.LotProperty;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.ui.MonopolySkin;

public class TradePropertyTable extends Table {
  private Table leftTable = new Table();
  private Table rightTable = new Table();
  private Player player;

  public TradePropertyTable(Player player, Boolean swap){
    this.player = player;
    fillTable(leftTable, rightTable, player, swap);
    add(leftTable);
    add(rightTable);
  }

  private void fillTable(Table keepTable, Table tradeTable, Player player, Boolean swap){
    for (Property property : player.properties){
      Label propertyLabel = new Label(property.name, new MonopolySkin());
      propertyLabel.setVisible(false);
      if (property.mortgaged){
        propertyLabel.setColor(Color.MAGENTA);
      }

      Button propertyButton;
      // It's a Lot
      if (LotProperty.class == property.getClass()){
        // Lot with houses: can't trade
        if (((LotProperty)property).numHouses > 0){
          propertyButton = new TextButton(property.name, new MonopolySkin());
          propertyButton.setColor(Color.SCARLET);
        }
        // Lot without houses
        else {
          propertyButton = new TradeButton(property.name, propertyLabel, tradeTable);
        }
      }
      // It's not a Lot
      else {
        propertyButton = new TradeButton(property.name, propertyLabel, tradeTable);
      }


      if (swap){
        leftTable.add(propertyButton).expandX().fill();
        leftTable.row();
        rightTable.add(propertyLabel).expandX().fill();
        rightTable.row();
      } else {
        leftTable.add(propertyLabel).expandX().fill();
        leftTable.row();
        rightTable.add(propertyButton).expandX().fill();
        rightTable.row();
      }
    }
  }
}
