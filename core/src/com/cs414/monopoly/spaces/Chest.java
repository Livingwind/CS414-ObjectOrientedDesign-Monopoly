package com.cs414.monopoly.spaces;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.JsonValue;

public class Chest extends Space {

  public Chest(String filename, JsonValue props) {
    super(filename, Size.STANDARD, SpaceFactory.SpaceType.CHEST);
    setName(props.get("name").asString());
  }
}
