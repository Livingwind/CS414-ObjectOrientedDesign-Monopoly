package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.Player;

public class IncomeTax extends AbstractSpace {
  IncomeTax(String filename, JsonValue props) {
    super(filename, props, Size.STANDARD);
  }

  @Override
  public void onLand(Player player) {

  }
}
