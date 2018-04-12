package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.Property;

public abstract class PropertySpace extends AbstractSpace {
  Property property;

  PropertySpace(String filename, int location, JsonValue props) {
    super(filename, location, props, Size.STANDARD);
  }

  void buyDialog(Player player) {
    // TODO Create a dialog for the player to purchase the property
    // TODO If no is selected, move to auction.
  }

  @Override
  public void onLand(Player player) {
    if(property.ownedBy != null) {
      if(!property.mortgaged) {
        player.modifyMoney(-property.getRent());
        return;
      }
    }

    buyDialog(player);
  }
}
