package com.cs414.monopoly.entities;

import com.badlogic.gdx.utils.JsonValue;

public class UtilityProperty extends Property{
  public UtilityProperty(String filename, JsonValue props) {
    super(filename, props);
  }

  public int getRent() {
    // TODO Have the current player roll dice
    int rollResult = 3;

    return rents[ownedBy.numUtilities - 1] * rollResult;
  }
}
