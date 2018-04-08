package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;

public class Luxury extends Space {
  public Luxury(String filename, JsonValue props) {
    super(filename, Space.Size.STANDARD, SpaceFactory.SpaceType.LUXURY);
    setName(props.get("name").asString());
  }
}
