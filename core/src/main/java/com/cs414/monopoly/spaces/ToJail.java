package com.cs414.monopoly.spaces;

import com.badlogic.gdx.utils.JsonValue;
import com.cs414.monopoly.entities.Player;
import com.cs414.monopoly.game.GameState;

public class ToJail extends AbstractSpace {

  ToJail(String filename, int location, JsonValue props) {
    super(filename, location, props, Size.CORNER);
  }

  @Override
  public void onLand(Player player) {
    GameState.getInstance().getBoard().sendToJail(player);
  }
}
