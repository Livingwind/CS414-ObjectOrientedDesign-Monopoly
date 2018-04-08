package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;

public class Income extends Space{

  public Income(String filename, JsonValue props) {
    super(filename, Size.STANDARD, SpaceFactory.SpaceType.INCOME);
    setName(props.get("name").asString());
  }
}
