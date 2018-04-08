package com.cs414.monopoly.spaces;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;

public class Utility extends Space {

  public Utility(String filename, JsonValue props) {
    super(filename, Size.STANDARD, SpaceFactory.SpaceType.UTILITY);
    setName(props.get("name").asString());
  }
}
