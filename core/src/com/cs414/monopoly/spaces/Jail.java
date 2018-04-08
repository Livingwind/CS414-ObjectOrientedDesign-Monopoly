package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;

public class Jail extends Space {
  public Jail(String filename, JsonValue props) {
    super(filename, Size.CORNER, SpaceFactory.SpaceType.JAIL);
    setName(props.get("name").asString());
  }
}
