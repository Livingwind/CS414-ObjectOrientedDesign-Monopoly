package com.cs414.monopoly.entities;

import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.game.GameState;

public class UtilityProperty extends Property{
  public UtilityProperty(String filename, JsonValue props) {
    super(filename, props);
  }

  public int getRent() {
    return rents[ownedBy.numUtilities - 1] * GameState.getInstance().lastRoll;
  }
}
