package main.com.cs414.monopoly.entities;

import com.badlogic.gdx.utils.JsonValue;

public class RailroadProperty extends Property {
  public RailroadProperty(String filename, JsonValue props) {
    super(filename, props);
  }

  public int getRent() {
    return rents[ownedBy.numRoads];
  }
}
