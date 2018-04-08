package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;

public class FreeParking extends Space {
  public FreeParking(String filename, JsonValue props) {
    super(filename, Size.CORNER, SpaceFactory.SpaceType.FREEPARKING);
    setName(props.get("name").asString());
  }
}
