package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.Player;

public class Go extends AbstractSpace {
  Go(String filename, int location, JsonValue props) {
    super(filename, location, props, Size.CORNER);
  }

  @Override
  public void onLand(Player player) {

  }
}
