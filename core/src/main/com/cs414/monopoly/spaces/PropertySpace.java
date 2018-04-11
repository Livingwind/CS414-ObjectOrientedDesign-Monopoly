package main.com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;
import main.com.cs414.monopoly.entities.Player;
import main.com.cs414.monopoly.entities.Property;

public abstract class PropertySpace extends AbstractSpace {
  Property property;

  PropertySpace(String filename, JsonValue props) {
    super(filename, props, Size.STANDARD);
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
