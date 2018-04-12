package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.Player;

public class Jail extends AbstractSpace {
  Jail(String filename, int location, JsonValue props) {
    super(filename, location, props, Size.STANDARD);
  }

  @Override
  public void onLand(Player player) {

  }
}
