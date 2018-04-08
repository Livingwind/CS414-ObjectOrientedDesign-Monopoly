package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;

public class Go extends Space {
  public Go(String filename, JsonValue props) {
    super(filename, Size.CORNER, SpaceFactory.SpaceType.GO);
    setName(props.get("name").asString());
  }
}
