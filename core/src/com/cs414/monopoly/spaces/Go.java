package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.Player;

public class Go extends AbstractSpace {
  Go(String filename, JsonValue props) {
    super(filename, props, Size.CORNER);
  }

  @Override
  public void onLand(Player player) {

  }
}
