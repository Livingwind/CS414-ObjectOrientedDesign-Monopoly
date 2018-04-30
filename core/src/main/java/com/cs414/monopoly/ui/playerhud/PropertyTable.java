package com.cs414.monopoly.ui.playerhud;

import com.badlogic.gdx.graphics.Color;
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
      Button propertyButton = buttons.textButton(property.name);
      propertyButton.addListener(listeners.propertyDialogListener(property));
      propertyButton.addListener(listeners.hoverListener(player, property));
      add(propertyButton).width(width * 0.6f);

      if (property.getClass() == LotProperty.class) {
        if (player.canPurchaseHouse((LotProperty)property)) {
          Button buyButton = buttons.buyButton(property);
          buyButton.addListener(listeners.hoverListener(player, property));
          buyButton.addListener(listeners.buyHouseListener(property));
          add(buyButton).width(width * 0.2f);
        }
        else {
          // Gray Buy Button
          add(buttons.textButton("Buy \uD83C\uDFE0", Color.LIGHT_GRAY)).width(width * 0.2f);
        }

        if (player.canSellHouse((LotProperty)property)) {
          Button sellButton = buttons.sellButton(property);
          sellButton.addListener(listeners.hoverListener(player, property));
          sellButton.addListener(listeners.sellHouseListener(property));
          add(sellButton).width(width * 0.2f);
        }
        else {
          // Gray Buy Button
          add(buttons.textButton("Sell \uD83C\uDFE0", Color.LIGHT_GRAY)).width(width * 0.2f);
        }
      }





      // Scale the PropertyTable height to fit the new row
      setSize(getWidth(), getHeight() + propertyButton.getHeight());
      row();
    }
  }
}
