package com.cs414.monopoly.ui.playerhud;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.cs414.monopoly.entities.LotProperty;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.ui.Buttons;
import com.cs414.monopoly.ui.Listeners;

/**
 * Creates a table of owned properties for the current player.
 * The width of the table is based on the width of CurrentPlayerInfo
 * @see CurrentPlayerInfo
 *
 *   Example:
 *           propertyButton(60%) buy(20%) sell(20%)
 *           _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _
 *   row 0  | railroad1         | n/a    | n/a     |
 *   row 1  | utility1          | n/a    | n/a     |
 *   row 2  | lot1              | buy    | sell    |
 *   (...)  | ...               | ...    | ...     |
 *          |_ _ _ _ _ _ _ _ _ _|_ _ _ _ |_ _ _ _ _|
 */
public class PropertyTable extends Table {
  private Player player;
  private Buttons buttons = new Buttons();
  private Listeners listeners = new Listeners();
  private float width = CurrentPlayerInfo.width; // get width from CurrentPlayerInfo

  @Override
  public void layout() {
    super.layout();
  }

  public PropertyTable(Player player) {
    this.player = player;
    setVisible(false);
    setSize(width,0);
  }

  public void update(){
    clear();
    row();
    setSize(width,0);
    for (int tableRow = 0; tableRow < player.properties.size(); ++tableRow) {
      Property property = player.properties.get(tableRow);

      // property button (60% of table width)
      Button propertyButton = buttons.getTextButton(property.name);
      propertyButton.addListener(listeners.getPropertyDialogListener(property));
      propertyButton.addListener(listeners.getHoverListener(player, property));
      add(propertyButton).width(width * 0.6f);

      // only add buy/sell house buttons to lot properties
      if (property.getClass() == LotProperty.class){

        // Add 'Buy 🏠' button (20% of table width)
        if (((LotProperty)property).numHouses < 5) {
          Button buyButton = buttons.getBuyButton(property);
          buyButton.addListener(listeners.getHoverListener(player, property));
          buyButton.addListener(listeners.getBuyHouseListener(property));
          add(buyButton).width(width * 0.2f);
        } else {
          // Gray Buy Button
          add(buttons.getGreyButton("Buy \uD83C\uDFE0")).width(width * 0.2f);
        }

        // Add 'Sell 🏠' button (20% of table width)
        if (((LotProperty)property).numHouses > 0) {
          Button sellButton = buttons.getSellButton(property);
          sellButton.addListener(listeners.getHoverListener(player, property));
          sellButton.addListener(listeners.getSellHouseListener(property));
          add(sellButton).width(width * 0.2f);
        } else {
          // Gray Sell button
          add(buttons.getGreyButton("Sell \uD83C\uDFE0")).width(width * 0.2f);
        }
      }

      // Scale the PropertyTable height to fit the new row
      setSize(getWidth(), getHeight() + propertyButton.getHeight());
      row();
    }
  }
}
