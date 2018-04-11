package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.LotProperty;

class Lot extends PropertySpace {
  Lot(String filename, JsonValue props) {
    super(filename, props);
    property = new LotProperty(filename, props);
  }
}
