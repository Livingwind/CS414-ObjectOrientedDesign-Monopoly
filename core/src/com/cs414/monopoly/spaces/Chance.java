package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;

public class Chance extends Space {
  public Chance(String filename, JsonValue props) {
    super(filename, Size.STANDARD, SpaceFactory.SpaceType.CHANCE);
    setName(props.get("name").asString());
  }
}
