package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;

public class ToJail extends Space {

  public ToJail(String filename, JsonValue props) {
    super(filename, Size.CORNER, SpaceFactory.SpaceType.TO_JAIL);
    setName(props.get("name").asString());
  }
}
