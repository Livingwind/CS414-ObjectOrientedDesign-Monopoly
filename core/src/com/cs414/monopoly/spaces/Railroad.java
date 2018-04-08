package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;

public class Railroad extends Space {

  public Railroad(String filename, JsonValue props) {
    super(filename, Size.STANDARD, SpaceFactory.SpaceType.RAILROAD);
    setName(props.get("name").asString());
  }
}
