package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.RailroadProperty;

class Railroad extends PropertySpace {
  Railroad(String filename, JsonValue props) {
    super(filename, props);
    property = new RailroadProperty(filename, props);
  }
}
