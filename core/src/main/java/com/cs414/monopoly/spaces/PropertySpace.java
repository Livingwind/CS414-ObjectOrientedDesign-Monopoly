package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.entities.Property;
import com.cs414.monopoly.ui.PropertyLandDialog;

public abstract class PropertySpace extends AbstractSpace {
  Property property;

  PropertySpace(String filename, int location, JsonValue props) {
    super(filename, location, props, Size.STANDARD);
  }

  @Override
  public void onLand(Player player) {
    new PropertyLandDialog(property);
  }
}
