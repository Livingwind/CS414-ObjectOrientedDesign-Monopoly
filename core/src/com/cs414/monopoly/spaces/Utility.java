package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.UtilityProperty;

class Utility extends PropertySpace {
  Utility(String filename, JsonValue props) {
    super(filename, props);
    property = new UtilityProperty(filename, props);
  }
}
